	public void rellenarPanelesSimplificado(String sArticulo, String sEmpresa) throws DAException {

		ApartadoEnum[] apartados = ApartadoEnum.values();
		for (int r = 0; r < apartados.length; r++) {
			apartados[r].setContador(0);
			apartados[r].setImagenInsertada(false);
			BOSegment iPanel = boObject.getSegment(SEGMENTS.valueOf(apartados[r].segment));
			iPanel.setAllowInsert(true);
			iPanel.deleteRows();
		}
		int iIdioma = session.getUserInfo().getLanguageCode();

		String valores = "";
		String nombres = "";
		String[] SituacionDatos1 = situacionColumna1.split("#");
		String[] SituacionDatos2 = situacionColumna2.split("#");
		String[] SituacionDatos3 = situacionColumna3.split("#");
		String[] SituacionDatos4 = situacionColumna4.split("#");
		String sSituacion1 = SituacionDatos1[0];
		String sSituacion2 = SituacionDatos2[0];
		String sSituacion3 = SituacionDatos3[0];
		String sSituacion4 = SituacionDatos4[0];
		String sSituaciones = "";

		if (!(sSituacion1 == null || sSituacion1.equals(""))) {
			programarCaracteristicas(session, sArticulo, sSituacion1);
			if (sSituaciones.equals("")) {
				sSituaciones = sSituacion1;
			} else {
				sSituaciones = sSituaciones + "," + sSituacion1;
			}
		}
		if (!(sSituacion2 == null || sSituacion2.equals(""))) {
			programarCaracteristicas(session, sArticulo, sSituacion2);
			if (sSituaciones.equals("")) {
				sSituaciones = sSituacion2;
			} else {
				sSituaciones = sSituaciones + "," + sSituacion2;
			}
		}
		if (!(sSituacion3 == null || sSituacion3.equals(""))) {
			programarCaracteristicas(session, sArticulo, sSituacion3);
			if (sSituaciones.equals("")) {
				sSituaciones = sSituacion3;
			} else {
				sSituaciones = sSituaciones + "," + sSituacion3;
			}
		}
		if (!(sSituacion4 == null || sSituacion4.equals(""))) {
			programarCaracteristicas(session, sArticulo, sSituacion4);
			if (sSituaciones.equals("")) {
				sSituaciones = sSituacion4;
			} else {
				sSituaciones = sSituaciones + "," + sSituacion4;
			}
		}

		String sCaracteristicasInsertadas = "";
		renombrarColumnas();
		// Sacamos los estados equivalentes a los check que tenga marcada la
		// caracteristica
		String sqlEstados = "";
		String sql = "select distinct isnull(est.xvalorcomercial,0)xvalorcomercial,oc.xdistinto distintoOC, oc.xvalor as valorOC,oc.xcaracteristica_f as caracOC,est.xorden,carac.xdistinto, carac.xvalor,carac.xcaracteristica_f, est.xcaracteristica_id,estados from (select SUBSTRING(caract.xestados,0,len(caract.xestados)) as estados,* "
				+ " from (select *, " + " case car.xmuestra when -1 then cast('2,' as varchar)else '' end + "
				+ " case car.xbasica when -1 then cast('0,' as varchar) else '' end + "
				+ " case car.xcomercial when -1 then cast('8,' as varchar) else '' end + "
				+ " case car.xinspeccion when -1 then cast('4,' as varchar) else '' end+"
				+ " case xmassproduction when -1 then cast('6,' as varchar) else '' end as xestados from "
				+ connSdic.translateTable("s_caracteristicas") + " car) caract )est" + " inner join "
				+ connSdic.translateTable("s_carac_fam") + " fam on fam.xcaracteristica_id = est.xcaracteristica_id"
				+ " left outer join " + connSdic.translateTable("s_carac_carac")
				+ " carac on carac.xcaracteristica_id=est.xcaracteristica_id and fam.xempresa_id = carac.xempresa_id"
				+ " left outer join " + connSdic.translateTable("s_carac_ocult")
				+ " oc on oc.xcaracteristica_id=est.xcaracteristica_id and fam.xempresa_id = oc.xempresa_id"
				+ " inner join " + connSdic.translateTable("s_art_carac")
				+ " art on art.xcaracteristica_id = est.xcaracteristica_id" + " where xbaja=0 and art.xarticulo_id='"
				+ sArticulo + "'";
		if (!sSituaciones.equals("")) {
			sql += " and (";
			if (!(sSituacion1 == null || sSituacion1.equals(""))) {
				sqlEstados += " (estados like('%" + sSituacion1 + "%')) or";
			}
			if (!(sSituacion2 == null || sSituacion2.equals(""))) {
				sqlEstados += " (estados like('%" + sSituacion2 + "%'))or";
			}
			if (!(sSituacion3 == null || sSituacion3.equals(""))) {
				sqlEstados += " (estados like('%" + sSituacion3 + "%'))or";
			}
			if (!(sSituacion4 == null || sSituacion4.equals(""))) {
				sqlEstados += " (estados like('%" + sSituacion4 + "%'))or";
			}
			sqlEstados = sqlEstados.substring(0, (sqlEstados.length() - 2));
			sql += sqlEstados + ")";
		}
		sql += " order by est.xorden";

		try (DAResultSet oRes3 = session.getConnectionData().openSQL(sql)) {
			while (oRes3.moveNext()) {
				String sCaracteristicaEstado = oRes3.getString("xcaracteristica_id");
				if(sCaracteristicaEstado.equals("MB100")) {
					System.out.println("para");
				}

				String sEspecial = oRes3.getString("xvalorcomercial");
				String sEspecial1 = "0";
				String sEspecial2 = "0";
				String sEspecial3 = "0";
				String sEspecial4 = "0";
				if (sEspecial.equals("-1")) {
					if (sSituacion1.equals("6") || sSituacion1.equals("8")) {
						sEspecial1 = "-1";
					}
					if (sSituacion2.equals("6") || sSituacion2.equals("8")) {
						sEspecial2 = "-1";
					}
					if (sSituacion3.equals("6") || sSituacion3.equals("8")) {
						sEspecial3 = "-1";
					}
					if (sSituacion4.equals("6") || sSituacion4.equals("8")) {
						sEspecial4 = "-1";
					}
				}
				String sSituacionesSeleccionadas="";
				if (!(sSituacion1.equals("") || sSituacion1==null)) {
					sSituacionesSeleccionadas = sSituacion1;
				}
				if (!(sSituacion2.equals("") || sSituacion2==null)) {
					if (!(sSituacionesSeleccionadas.equals("") || sSituacionesSeleccionadas==null)) {
						sSituacionesSeleccionadas=sSituacionesSeleccionadas+",";
					}
					sSituacionesSeleccionadas = sSituacionesSeleccionadas+ sSituacion2;
				}
				if (!(sSituacion3.equals("") || sSituacion3==null)) {
					if (!(sSituacionesSeleccionadas.equals("") || sSituacionesSeleccionadas==null)) {
						sSituacionesSeleccionadas=sSituacionesSeleccionadas+",";
					}
					sSituacionesSeleccionadas = sSituacionesSeleccionadas+ sSituacion3;
				}	
				if (!(sSituacion4.equals("") || sSituacion4==null)) {
					if (!(sSituacionesSeleccionadas.equals("") || sSituacionesSeleccionadas==null)) {
						sSituacionesSeleccionadas=sSituacionesSeleccionadas+",";
					}
					sSituacionesSeleccionadas = sSituacionesSeleccionadas+ sSituacion4;
				}
				
				String sEstados = oRes3.getString("estados");
				String sCaracteristicaFiltro = oRes3.getString("xcaracteristica_f");
				String sValorFiltro = oRes3.getString("xvalor");
				String sDistinto = oRes3.getString("xdistinto");
				if (sDistinto == null || sDistinto.equals("")) {
					sDistinto = "0";
				}
				String sCaracteristicaFiltroOc = oRes3.getString("caracOC");
				String sValorFiltroOc = oRes3.getString("valorOC");
				String sDistintoOc = oRes3.getString("distintoOC");
				if (sDistintoOc == null || sDistintoOc.equals("")) {
					sDistintoOc = "0";
				}
				boolean pasaFiltro = false;
				if ((!(sCaracteristicaFiltro == null || sCaracteristicaFiltro.equals("")))
						&& (!(sValorFiltro == null || sValorFiltro.equals("")))) {
					if (sDistinto.equals("0")) {
						if (SUL_UTILS_ART.isNumeric(sValorFiltro)) {
							// Comprobamos si tienen algun filtro las caracteristicas.
							sql = "select xcaracteristica_id from " + connSdic.translateTable("s_art_carac")
									+ " where xarticulo_id ='" + sArticulo + "' and xcaracteristica_id='"
									+ sCaracteristicaFiltro + "' and xvalorlista1='" + sValorFiltro + "' and xsituacion_dsp in ("+sSituacionesSeleccionadas+")";
							try (DAResultSet oRes = session.getConnectionData().openSQL(sql)) {
								if (oRes.moveNext()) {
									pasaFiltro = true;
								}
								oRes.close();
							} catch (OTException ot) {
								ot.printStackTrace();
								oRes.close();
								try {
									throw new PMException(session, ot);
								} catch (PMException e) {
									e.printStackTrace();
								}
							}
						}
					} else {
						sql = "select xcaracteristica_id from " + connSdic.translateTable("s_art_carac")
								+ " where xarticulo_id ='" + sArticulo + "' and xcaracteristica_id='"
								+ sCaracteristicaFiltro + "' and xvalorlista1!='" + sValorFiltro + "' and xsituacion_dsp in ("+sSituacionesSeleccionadas+")";
						try (DAResultSet oRes = session.getConnectionData().openSQL(sql)) {
							if (oRes.moveNext()) {
								pasaFiltro = true;
							}
							oRes.close();
						} catch (OTException ot) {
							ot.printStackTrace();
							oRes.close();
							try {
								throw new PMException(session, ot);
							} catch (PMException e) {
								e.printStackTrace();
							}
						}
					}
				} else {
					pasaFiltro = true;
				}

				// Ocultamos caracteristicas
				if ((!(sCaracteristicaFiltroOc == null || sCaracteristicaFiltroOc.equals("")))
						&& (!(sValorFiltroOc == null || sValorFiltroOc.equals("")))) {
					if (sDistintoOc.equals("0")) {
						if (SUL_UTILS_ART.isNumeric(sValorFiltroOc)) {
							// Comprobamos si tienen algun filtro las caracteristicas.
							sql = "select xcaracteristica_id from " + connSdic.translateTable("s_art_carac")
									+ " where xarticulo_id ='" + sArticulo + "' and xcaracteristica_id='"
									+ sCaracteristicaFiltroOc + "' and xvalorlista1='" + sValorFiltroOc + "'  and xsituacion_dsp in ("+sSituacionesSeleccionadas+")";
							try (DAResultSet oRes = session.getConnectionData().openSQL(sql)) {
								if (oRes.moveNext()) {
									pasaFiltro = false;
								}
								oRes.close();
							} catch (OTException ot) {
								ot.printStackTrace();
								oRes.close();
								try {
									throw new PMException(session, ot);
								} catch (PMException e) {
									e.printStackTrace();
								}
							}
						}
					} else {
						sql = "select xcaracteristica_id from " + connSdic.translateTable("s_art_carac")
								+ " where xarticulo_id ='" + sArticulo + "' and xcaracteristica_id='"
								+ sCaracteristicaFiltroOc + "' and xvalorlista1!='" + sValorFiltroOc + "' and xsituacion_dsp in ("+sSituacionesSeleccionadas+")";
						try (DAResultSet oRes = session.getConnectionData().openSQL(sql)) {
							if (oRes.moveNext()) {
								pasaFiltro = false;
							}
							oRes.close();
						} catch (OTException ot) {
							ot.printStackTrace();
							oRes.close();
							try {
								throw new PMException(session, ot);
							} catch (PMException e) {
								e.printStackTrace();
							}
						}
					}
				}

				if (pasaFiltro == true) {
					if (!(sCaracteristicaEstado == null || sCaracteristicaEstado.equals(""))) {
						if (!(sEstados == null || sEstados.equals(""))) {
							// Rellenamos los datos de los grid, tenemos 4 union, solo si tiene situaciones
							// de la dsp creadas, en función de la cantidad de caracteristicas que tenga se
							// rellenan de 1 a 4 columnas.
							if (sCaracteristicasInsertadas.contains(sCaracteristicaEstado)) {
								continue;
							}
							sql = "select carmlg.xdescripcion,isnull(carmlg.xnombre1,car.xnombre1)xnombre1, isnull(carmlg.xnombre2,car.xnombre2)xnombre2,art.xsituacion_dsp situacionArt,gen.xfamilia_produc,gen.xtecnologia"
									+ ",gen.xsituacion_dsp,car.xapartado_id,car.xtipo_valor,art.xempresa_id,art.xarticulo_id,art.xcaracteristica_id,mlg.xdescripcion"
									+ ",lista.xlista_id,lista.xfiltro_id, car.xtipo_valor,car.xlista1,case car.xtipo_valor "
									+ "when 0 then cast(art.xvalorpasa1 as varchar) "
									+ "when 1 then cast(mlg.xdescripcion as varchar) " + "when 2 then "
									+ "CASE WHEN cast(art.xvalortexto1 as varchar) IS NULL OR cast(art.xvalortexto1 as varchar)= '' THEN ''"
									+ " ELSE cast(art.xvalortexto1 as varchar)END +"
									+ "CASE WHEN cast(art.xvalortexto2 as varchar) IS NULL OR cast(art.xvalortexto2 as varchar)= '' THEN '' "
									+ "ELSE ' / ' + cast(art.xvalortexto2 as varchar)END +"
									+ "CASE WHEN cast(art.xvalortexto3 as varchar)IS NULL OR cast(art.xvalortexto3 as varchar)= '' THEN '' "
									+ "ELSE ' / ' + cast(art.xvalortexto3 as varchar) END +"
									+ "CASE WHEN cast(art.xvalortexto4 as varchar)IS NULL OR cast(art.xvalortexto4 as varchar)= '' THEN '' "
									+ "ELSE ' / ' + cast(art.xvalortexto4 as varchar) END +"
									+ "CASE WHEN cast(art.xvalortexto5 as varchar)IS NULL OR cast(art.xvalortexto5 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalortexto5 as varchar) END +"
									+ "CASE WHEN cast(art.xvalortexto6 as varchar)IS NULL OR cast(art.xvalortexto6 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalortexto6 as varchar) END +"
									+ "CASE WHEN cast(art.xvalortexto7 as varchar)IS NULL OR cast(art.xvalortexto7 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalortexto7 as varchar) END +"
									+ "CASE WHEN cast(art.xvalortexto8 as varchar)IS NULL OR cast(art.xvalortexto8 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalortexto8 as varchar) END +"
									+ "CASE WHEN cast(art.xvalortexto9 as varchar)IS NULL OR cast(art.xvalortexto9 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalortexto9 as varchar) END +"
									+ "CASE WHEN cast(art.xvalortexto10 as varchar)IS NULL OR cast(art.xvalortexto10 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalortexto10 as varchar) END " + "when 3 then "
									+ "CASE WHEN cast(art.xvalorint1 as varchar) IS NULL OR cast(art.xvalorint1 as varchar)= '' THEN '' "
									+ "ELSE cast(art.xvalorint1 as varchar)END +"
									+ "CASE WHEN cast(art.xvalorint2 as varchar) IS NULL OR cast(art.xvalorint2 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalorint2 as varchar)END +"
									+ "CASE WHEN cast(art.xvalorint3 as varchar)IS NULL OR cast(art.xvalorint3 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalorint3 as varchar) END +"
									+ "CASE WHEN cast(art.xvalorint4 as varchar)IS NULL OR cast(art.xvalorint4 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalorint4 as varchar) END +"
									+ "CASE WHEN cast(art.xvalorint5 as varchar)IS NULL OR cast(art.xvalorint5 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalorint5 as varchar) END +"
									+ "CASE WHEN cast(art.xvalorint6 as varchar)IS NULL OR cast(art.xvalorint6 as varchar)= '' THEN '' "
									+ "ELSE ' / ' + cast(art.xvalorint6 as varchar) END+"
									+ "CASE WHEN cast(art.xvalorint7 as varchar)IS NULL OR cast(art.xvalorint7 as varchar)= '' THEN '' "
									+ "ELSE ' / ' + cast(art.xvalorint7 as varchar) END+"
									+ "CASE WHEN cast(art.xvalorint8 as varchar)IS NULL OR cast(art.xvalorint8 as varchar)= '' THEN '' "
									+ "ELSE ' / ' + cast(art.xvalorint8 as varchar) END+"
									+ "CASE WHEN cast(art.xvalorint9 as varchar)IS NULL OR cast(art.xvalorint9 as varchar)= '' THEN '' "
									+ "ELSE ' / ' + cast(art.xvalorint9 as varchar) END+"
									+ "CASE WHEN cast(art.xvalorint10 as varchar)IS NULL OR cast(art.xvalorint10 as varchar)= '' THEN '' "
									+ "ELSE ' / ' + cast(art.xvalorint10 as varchar) END" + " when 4 then "
									+ "CASE WHEN cast(art.xvalordecimal1 as varchar) IS NULL OR cast(art.xvalordecimal1 as varchar)= '' "
									+ "THEN '' ELSE format(art.xvalordecimal1,'n','es-es')END +"
									+ "CASE WHEN cast(art.xvalordecimal2 as varchar) IS NULL OR cast(art.xvalordecimal2 as varchar)= ''"
									+ " THEN '' ELSE ' / ' + format(art.xvalordecimal2,'n','es-es')END +"
									+ "CASE WHEN cast(art.xvalordecimal3 as varchar)IS NULL OR cast(art.xvalordecimal3 as varchar)= ''"
									+ " THEN '' ELSE ' / ' + format(art.xvalordecimal3,'n','es-es') END +"
									+ "CASE WHEN cast(art.xvalordecimal4 as varchar)IS NULL OR cast(art.xvalordecimal4 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + format(art.xvalordecimal4,'n','es-es') END +"
									+ "CASE WHEN cast(art.xvalordecimal5 as varchar)IS NULL OR cast(art.xvalordecimal5 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + format(art.xvalordecimal5,'n','es-es') END +"
									+ "CASE WHEN cast(art.xvalordecimal6 as varchar)IS NULL OR cast(art.xvalordecimal6 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + format(art.xvalordecimal6,'n','es-es') END+"
									+ "CASE WHEN cast(art.xvalordecimal7 as varchar)IS NULL OR cast(art.xvalordecimal7 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + format(art.xvalordecimal7,'n','es-es') END+"
									+ "CASE WHEN cast(art.xvalordecimal8 as varchar)IS NULL OR cast(art.xvalordecimal8 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + format(art.xvalordecimal8,'n','es-es') END+"
									+ "CASE WHEN cast(art.xvalordecimal9 as varchar)IS NULL OR cast(art.xvalordecimal9 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + format(art.xvalordecimal9,'n','es-es') END+"
									+ "CASE WHEN cast(art.xvalordecimal10 as varchar)IS NULL OR cast(art.xvalordecimal10 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + format(art.xvalordecimal10,'n','es-es') END" + " end as valores,"
									+ " case " + sEspecial1 + " when -1 then("
									+ "(CASE WHEN cast(art.xvalortexto1 as varchar) IS NULL OR cast(art.xvalortexto1 as varchar)= '' THEN ''"
									+ " ELSE cast(art.xvalortexto1 as varchar)END +"
									+ "CASE WHEN cast(art.xvalortexto2 as varchar) IS NULL OR cast(art.xvalortexto2 as varchar)= '' THEN '' "
									+ "ELSE ' / ' + cast(art.xvalortexto2 as varchar)END +"
									+ "CASE WHEN cast(art.xvalortexto3 as varchar)IS NULL OR cast(art.xvalortexto3 as varchar)= '' THEN '' "
									+ "ELSE ' / ' + cast(art.xvalortexto3 as varchar) END +"
									+ "CASE WHEN cast(art.xvalortexto4 as varchar)IS NULL OR cast(art.xvalortexto4 as varchar)= '' THEN '' "
									+ "ELSE ' / ' + cast(art.xvalortexto4 as varchar) END +"
									+ "CASE WHEN cast(art.xvalortexto5 as varchar)IS NULL OR cast(art.xvalortexto5 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalortexto5 as varchar) END +"
									+ "CASE WHEN cast(art.xvalortexto6 as varchar)IS NULL OR cast(art.xvalortexto6 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalortexto6 as varchar) END )) else '' end"
									+ "  as valores2"
									+ ", CASE WHEN cast(car.xnombre1 as varchar) IS NULL OR cast(car.xnombre1  as varchar)= '' THEN '' ELSE cast(car.xnombre1  as varchar)END +"
									+ " CASE WHEN cast(car.xnombre2 as varchar) IS NULL OR cast(car.xnombre2  as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre2  as varchar)END +"
									+ " CASE WHEN cast(car.xnombre3  as varchar)IS NULL OR cast(car.xnombre3 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre3 as varchar) END +"
									+ " CASE WHEN cast(car.xnombre4 as varchar)IS NULL OR cast(car.xnombre4  as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre4  as varchar) END +"
									+ " CASE WHEN cast(car.xnombre5 as varchar)IS NULL OR cast(car.xnombre5 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre5 as varchar) END +"
									+ " CASE WHEN cast(car.xnombre6 as varchar)IS NULL OR cast(car.xnombre6 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre6 as varchar) END+"
									+ " CASE WHEN cast(car.xnombre7 as varchar)IS NULL OR cast(car.xnombre7 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre7 as varchar) END +"
									+ " CASE WHEN cast(car.xnombre8 as varchar)IS NULL OR cast(car.xnombre8 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre8 as varchar) END +"
									+ " CASE WHEN cast(car.xnombre9 as varchar)IS NULL OR cast(car.xnombre9 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre9 as varchar) END +"
									+ " CASE WHEN cast(car.xnombre10 as varchar)IS NULL OR cast(car.xnombre10 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre10 as varchar) END "
									+ " as nombres," + " apart.xdescripcion as nom_apart" + " from "
									+ connSdic.translateTable("s_art_carac") + " art " + " inner join "
									+ connSdic.translateTable("s_caracteristicas")
									+ " car on art.xcaracteristica_id=car.xcaracteristica_id "
									+ " left outer join imp.s_caracteristicasmlg"
									+ " carmlg on carmlg.xcaracteristica_id=car.xcaracteristica_id" + " inner join "
									+ connSdic.translateTable("pl_articulos")
									+ " gen on gen.xarticulo_id = art.xarticulo_id and gen.xempresa_id = art.xempresa_id"
									+ " inner join " + connSdic.translateTable("s_carac_fam")
									+ " fam on fam.xempresa_id = art.xempresa_id and fam.xcaracteristica_id = car.xcaracteristica_id"
									+ " left outer join " + connSdic.translateTable("sul_art_listas")
									+ " lista on lista.xlista_id=car.xlista1 and art.xvalorlista1=lista.xlinea_id "
									+ " left outer join imp.sul_art_listasmlg mlg on mlg.xlista_id=lista.xlista_id and mlg.xlinea_id=lista.xlinea_id"
									+ " left outer join imp.s_apartados apart on apart.xapartado_id=car.xapartado_id"
									+ " where art.xempresa_id='" + sEmpresa + "' and  art.xarticulo_id='" + sArticulo
									+ "'"
									+ " and gen.xfamilia_produc=fam.xfamilia_id and gen.xtecnologia = fam.xssfamilia_id"
									+ " and car.xbaja=0 " + " and car.xcaracteristica_id='" + sCaracteristicaEstado
									+ "'" + " and isnull(mlg.idioma," + iIdioma + ") = '" + iIdioma
									+ "' and isnull(carmlg.idioma," + iIdioma + ") = '" + iIdioma
									+ "' and art.xsituacion_dsp='" + sSituacion1 + "'";
							if (!(sSituacion2 == null || sSituacion2.equals(""))) {
								sql += "union"
										+ " select carmlg.xdescripcion,isnull(carmlg.xnombre1,car.xnombre1)xnombre1, isnull(carmlg.xnombre2,car.xnombre2)xnombre2,art.xsituacion_dsp situacionArt,gen.xfamilia_produc,gen.xtecnologia,gen.xsituacion_dsp,car.xapartado_id,car.xtipo_valor,art.xempresa_id,art.xarticulo_id,art.xcaracteristica_id,mlg.xdescripcion"
										+ ",lista.xlista_id,lista.xfiltro_id, car.xtipo_valor,car.xlista1,case car.xtipo_valor "
										+ "when 0 then cast(art.xvalorpasa1 as varchar) "
										+ "when 1 then cast(mlg.xdescripcion as varchar) " + "when 2 then "
										+ "CASE WHEN cast(art.xvalortexto1 as varchar) IS NULL OR cast(art.xvalortexto1 as varchar)= '' THEN ''"
										+ " ELSE cast(art.xvalortexto1 as varchar)END +"
										+ "CASE WHEN cast(art.xvalortexto2 as varchar) IS NULL OR cast(art.xvalortexto2 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto2 as varchar)END +"
										+ "CASE WHEN cast(art.xvalortexto3 as varchar)IS NULL OR cast(art.xvalortexto3 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto3 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto4 as varchar)IS NULL OR cast(art.xvalortexto4 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto4 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto5 as varchar)IS NULL OR cast(art.xvalortexto5 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto5 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto6 as varchar)IS NULL OR cast(art.xvalortexto6 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto6 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto7 as varchar)IS NULL OR cast(art.xvalortexto7 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto7 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto8 as varchar)IS NULL OR cast(art.xvalortexto8 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto8 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto9 as varchar)IS NULL OR cast(art.xvalortexto9 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto9 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto10 as varchar)IS NULL OR cast(art.xvalortexto10 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto10 as varchar) END " + "when 3 then "
										+ "CASE WHEN cast(art.xvalorint1 as varchar) IS NULL OR cast(art.xvalorint1 as varchar)= '' THEN '' "
										+ "ELSE cast(art.xvalorint1 as varchar)END +"
										+ "CASE WHEN cast(art.xvalorint2 as varchar) IS NULL OR cast(art.xvalorint2 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalorint2 as varchar)END +"
										+ "CASE WHEN cast(art.xvalorint3 as varchar)IS NULL OR cast(art.xvalorint3 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalorint3 as varchar) END +"
										+ "CASE WHEN cast(art.xvalorint4 as varchar)IS NULL OR cast(art.xvalorint4 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalorint4 as varchar) END +"
										+ "CASE WHEN cast(art.xvalorint5 as varchar)IS NULL OR cast(art.xvalorint5 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalorint5 as varchar) END +"
										+ "CASE WHEN cast(art.xvalorint6 as varchar)IS NULL OR cast(art.xvalorint6 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalorint6 as varchar) END+"
										+ "CASE WHEN cast(art.xvalorint7 as varchar)IS NULL OR cast(art.xvalorint7 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalorint7 as varchar) END+"
										+ "CASE WHEN cast(art.xvalorint8 as varchar)IS NULL OR cast(art.xvalorint8 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalorint8 as varchar) END+"
										+ "CASE WHEN cast(art.xvalorint9 as varchar)IS NULL OR cast(art.xvalorint9 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalorint9 as varchar) END+"
										+ "CASE WHEN cast(art.xvalorint10 as varchar)IS NULL OR cast(art.xvalorint10 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalorint10 as varchar) END" + " when 4 then "
										+ "CASE WHEN cast(art.xvalordecimal1 as varchar) IS NULL OR cast(art.xvalordecimal1 as varchar)= '' "
										+ "THEN '' ELSE format(art.xvalordecimal1,'n','es-es')END +"
										+ "CASE WHEN cast(art.xvalordecimal2 as varchar) IS NULL OR cast(art.xvalordecimal2 as varchar)= ''"
										+ " THEN '' ELSE ' / ' + format(art.xvalordecimal2,'n','es-es')END +"
										+ "CASE WHEN cast(art.xvalordecimal3 as varchar)IS NULL OR cast(art.xvalordecimal3 as varchar)= ''"
										+ " THEN '' ELSE ' / ' + format(art.xvalordecimal3,'n','es-es') END +"
										+ "CASE WHEN cast(art.xvalordecimal4 as varchar)IS NULL OR cast(art.xvalordecimal4 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal4,'n','es-es') END +"
										+ "CASE WHEN cast(art.xvalordecimal5 as varchar)IS NULL OR cast(art.xvalordecimal5 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal5,'n','es-es') END +"
										+ "CASE WHEN cast(art.xvalordecimal6 as varchar)IS NULL OR cast(art.xvalordecimal6 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal6,'n','es-es') END+"
										+ "CASE WHEN cast(art.xvalordecimal7 as varchar)IS NULL OR cast(art.xvalordecimal7 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal7,'n','es-es') END+"
										+ "CASE WHEN cast(art.xvalordecimal8 as varchar)IS NULL OR cast(art.xvalordecimal8 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal8,'n','es-es') END+"
										+ "CASE WHEN cast(art.xvalordecimal9 as varchar)IS NULL OR cast(art.xvalordecimal9 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal9,'n','es-es') END+"
										+ "CASE WHEN cast(art.xvalordecimal10 as varchar)IS NULL OR cast(art.xvalordecimal10 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal10,'n','es-es') END"
										+ " end as valores," + " case " + sEspecial2 + " when -1 then("
										+ "(CASE WHEN cast(art.xvalortexto1 as varchar) IS NULL OR cast(art.xvalortexto1 as varchar)= '' THEN ''"
										+ " ELSE cast(art.xvalortexto1 as varchar)END +"
										+ "CASE WHEN cast(art.xvalortexto2 as varchar) IS NULL OR cast(art.xvalortexto2 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto2 as varchar)END +"
										+ "CASE WHEN cast(art.xvalortexto3 as varchar)IS NULL OR cast(art.xvalortexto3 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto3 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto4 as varchar)IS NULL OR cast(art.xvalortexto4 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto4 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto5 as varchar)IS NULL OR cast(art.xvalortexto5 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto5 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto6 as varchar)IS NULL OR cast(art.xvalortexto6 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto6 as varchar) END )) else '' end"
										+ "  as valores2"
										+ ", CASE WHEN cast(car.xnombre1 as varchar) IS NULL OR cast(car.xnombre1  as varchar)= '' THEN '' ELSE cast(car.xnombre1  as varchar)END +"
										+ " CASE WHEN cast(car.xnombre2 as varchar) IS NULL OR cast(car.xnombre2  as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre2  as varchar)END +"
										+ " CASE WHEN cast(car.xnombre3  as varchar)IS NULL OR cast(car.xnombre3 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre3 as varchar) END +"
										+ " CASE WHEN cast(car.xnombre4 as varchar)IS NULL OR cast(car.xnombre4  as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre4  as varchar) END +"
										+ " CASE WHEN cast(car.xnombre5 as varchar)IS NULL OR cast(car.xnombre5 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre5 as varchar) END +"
										+ " CASE WHEN cast(car.xnombre6 as varchar)IS NULL OR cast(car.xnombre6 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre6 as varchar) END+"
										+ " CASE WHEN cast(car.xnombre7 as varchar)IS NULL OR cast(car.xnombre7 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre7 as varchar) END +"
										+ " CASE WHEN cast(car.xnombre8 as varchar)IS NULL OR cast(car.xnombre8 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre8 as varchar) END +"
										+ " CASE WHEN cast(car.xnombre9 as varchar)IS NULL OR cast(car.xnombre9 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre9 as varchar) END +"
										+ " CASE WHEN cast(car.xnombre10 as varchar)IS NULL OR cast(car.xnombre10 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre10 as varchar) END "
										+ " as nombres," + " apart.xdescripcion as nom_apart" + " from "
										+ connSdic.translateTable("s_art_carac") + " art " + " inner join "
										+ connSdic.translateTable("s_caracteristicas")
										+ " car on art.xcaracteristica_id=car.xcaracteristica_id "
										+ " left outer join imp.s_caracteristicasmlg"
										+ " carmlg on carmlg.xcaracteristica_id=car.xcaracteristica_id" + " inner join "
										+ connSdic.translateTable("pl_articulos")
										+ " gen on gen.xarticulo_id = art.xarticulo_id and gen.xempresa_id = art.xempresa_id"
										+ " inner join " + connSdic.translateTable("s_carac_fam")
										+ " fam on fam.xempresa_id = art.xempresa_id and fam.xcaracteristica_id = car.xcaracteristica_id"
										+ " left outer join " + connSdic.translateTable("sul_art_listas")
										+ " lista on lista.xlista_id=car.xlista1 and art.xvalorlista1=lista.xlinea_id "
										+ " left outer join imp.sul_art_listasmlg mlg on mlg.xlista_id=lista.xlista_id and mlg.xlinea_id=lista.xlinea_id"
										+ " left outer join imp.s_apartados apart on apart.xapartado_id=car.xapartado_id"
										+ " where  art.xempresa_id='" + sEmpresa + "' and  art.xarticulo_id='"
										+ sArticulo + "' "
										+ " and gen.xfamilia_produc=fam.xfamilia_id and gen.xtecnologia = fam.xssfamilia_id"
										+ " and car.xbaja=0 " + " and car.xcaracteristica_id='" + sCaracteristicaEstado
										+ "'" + " and isnull(mlg.idioma," + iIdioma + ") = '" + iIdioma
										+ "' and isnull(carmlg.idioma," + iIdioma + ") = '" + iIdioma
										+ "' and art.xsituacion_dsp='" + sSituacion2 + "'";
							}
							if (!(sSituacion3 == null || sSituacion3.equals(""))) {
								sql += "union"
										+ " select carmlg.xdescripcion,isnull(carmlg.xnombre1,car.xnombre1)xnombre1, isnull(carmlg.xnombre2,car.xnombre2)xnombre2,art.xsituacion_dsp situacionArt,gen.xfamilia_produc,gen.xtecnologia,gen.xsituacion_dsp,car.xapartado_id,car.xtipo_valor,art.xempresa_id,art.xarticulo_id,art.xcaracteristica_id,mlg.xdescripcion"
										+ ",lista.xlista_id,lista.xfiltro_id, car.xtipo_valor,car.xlista1,case car.xtipo_valor "
										+ "when 0 then cast(art.xvalorpasa1 as varchar) "
										+ "when 1 then cast(mlg.xdescripcion as varchar) " + "when 2 then "
										+ "CASE WHEN cast(art.xvalortexto1 as varchar) IS NULL OR cast(art.xvalortexto1 as varchar)= '' THEN ''"
										+ " ELSE cast(art.xvalortexto1 as varchar)END +"
										+ "CASE WHEN cast(art.xvalortexto2 as varchar) IS NULL OR cast(art.xvalortexto2 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto2 as varchar)END +"
										+ "CASE WHEN cast(art.xvalortexto3 as varchar)IS NULL OR cast(art.xvalortexto3 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto3 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto4 as varchar)IS NULL OR cast(art.xvalortexto4 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto4 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto5 as varchar)IS NULL OR cast(art.xvalortexto5 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto5 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto6 as varchar)IS NULL OR cast(art.xvalortexto6 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto6 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto7 as varchar)IS NULL OR cast(art.xvalortexto7 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto7 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto8 as varchar)IS NULL OR cast(art.xvalortexto8 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto8 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto9 as varchar)IS NULL OR cast(art.xvalortexto9 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto9 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto10 as varchar)IS NULL OR cast(art.xvalortexto10 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto10 as varchar) END " + "when 3 then "
										+ "CASE WHEN cast(art.xvalorint1 as varchar) IS NULL OR cast(art.xvalorint1 as varchar)= '' THEN '' "
										+ "ELSE cast(art.xvalorint1 as varchar)END +"
										+ "CASE WHEN cast(art.xvalorint2 as varchar) IS NULL OR cast(art.xvalorint2 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalorint2 as varchar)END +"
										+ "CASE WHEN cast(art.xvalorint3 as varchar)IS NULL OR cast(art.xvalorint3 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalorint3 as varchar) END +"
										+ "CASE WHEN cast(art.xvalorint4 as varchar)IS NULL OR cast(art.xvalorint4 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalorint4 as varchar) END +"
										+ "CASE WHEN cast(art.xvalorint5 as varchar)IS NULL OR cast(art.xvalorint5 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalorint5 as varchar) END +"
										+ "CASE WHEN cast(art.xvalorint6 as varchar)IS NULL OR cast(art.xvalorint6 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalorint6 as varchar) END+"
										+ "CASE WHEN cast(art.xvalorint7 as varchar)IS NULL OR cast(art.xvalorint7 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalorint7 as varchar) END+"
										+ "CASE WHEN cast(art.xvalorint8 as varchar)IS NULL OR cast(art.xvalorint8 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalorint8 as varchar) END+"
										+ "CASE WHEN cast(art.xvalorint9 as varchar)IS NULL OR cast(art.xvalorint9 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalorint9 as varchar) END+"
										+ "CASE WHEN cast(art.xvalorint10 as varchar)IS NULL OR cast(art.xvalorint10 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalorint10 as varchar) END" + " when 4 then "
										+ "CASE WHEN cast(art.xvalordecimal1 as varchar) IS NULL OR cast(art.xvalordecimal1 as varchar)= '' "
										+ "THEN '' ELSE format(art.xvalordecimal1,'n','es-es')END +"
										+ "CASE WHEN cast(art.xvalordecimal2 as varchar) IS NULL OR cast(art.xvalordecimal2 as varchar)= ''"
										+ " THEN '' ELSE ' / ' + format(art.xvalordecimal2,'n','es-es')END +"
										+ "CASE WHEN cast(art.xvalordecimal3 as varchar)IS NULL OR cast(art.xvalordecimal3 as varchar)= ''"
										+ " THEN '' ELSE ' / ' + format(art.xvalordecimal3,'n','es-es') END +"
										+ "CASE WHEN cast(art.xvalordecimal4 as varchar)IS NULL OR cast(art.xvalordecimal4 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal4,'n','es-es') END +"
										+ "CASE WHEN cast(art.xvalordecimal5 as varchar)IS NULL OR cast(art.xvalordecimal5 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal5,'n','es-es') END +"
										+ "CASE WHEN cast(art.xvalordecimal6 as varchar)IS NULL OR cast(art.xvalordecimal6 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal6,'n','es-es') END+"
										+ "CASE WHEN cast(art.xvalordecimal7 as varchar)IS NULL OR cast(art.xvalordecimal7 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal7,'n','es-es') END+"
										+ "CASE WHEN cast(art.xvalordecimal8 as varchar)IS NULL OR cast(art.xvalordecimal8 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal8,'n','es-es') END+"
										+ "CASE WHEN cast(art.xvalordecimal9 as varchar)IS NULL OR cast(art.xvalordecimal9 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal9,'n','es-es') END+"
										+ "CASE WHEN cast(art.xvalordecimal10 as varchar)IS NULL OR cast(art.xvalordecimal10 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal10,'n','es-es') END"
										+ " end as valores," + " case " + sEspecial3 + " when -1 then("
										+ "(CASE WHEN cast(art.xvalortexto1 as varchar) IS NULL OR cast(art.xvalortexto1 as varchar)= '' THEN ''"
										+ " ELSE cast(art.xvalortexto1 as varchar)END +"
										+ "CASE WHEN cast(art.xvalortexto2 as varchar) IS NULL OR cast(art.xvalortexto2 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto2 as varchar)END +"
										+ "CASE WHEN cast(art.xvalortexto3 as varchar)IS NULL OR cast(art.xvalortexto3 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto3 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto4 as varchar)IS NULL OR cast(art.xvalortexto4 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto4 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto5 as varchar)IS NULL OR cast(art.xvalortexto5 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto5 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto6 as varchar)IS NULL OR cast(art.xvalortexto6 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto6 as varchar) END )) else '' end"
										+ "  as valores2"
										+ ", CASE WHEN cast(car.xnombre1 as varchar) IS NULL OR cast(car.xnombre1  as varchar)= '' THEN '' ELSE cast(car.xnombre1  as varchar)END +"
										+ " CASE WHEN cast(car.xnombre2 as varchar) IS NULL OR cast(car.xnombre2  as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre2  as varchar)END +"
										+ " CASE WHEN cast(car.xnombre3  as varchar)IS NULL OR cast(car.xnombre3 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre3 as varchar) END +"
										+ " CASE WHEN cast(car.xnombre4 as varchar)IS NULL OR cast(car.xnombre4  as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre4  as varchar) END +"
										+ " CASE WHEN cast(car.xnombre5 as varchar)IS NULL OR cast(car.xnombre5 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre5 as varchar) END +"
										+ " CASE WHEN cast(car.xnombre6 as varchar)IS NULL OR cast(car.xnombre6 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre6 as varchar) END+"
										+ " CASE WHEN cast(car.xnombre7 as varchar)IS NULL OR cast(car.xnombre7 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre7 as varchar) END +"
										+ " CASE WHEN cast(car.xnombre8 as varchar)IS NULL OR cast(car.xnombre8 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre8 as varchar) END +"
										+ " CASE WHEN cast(car.xnombre9 as varchar)IS NULL OR cast(car.xnombre9 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre9 as varchar) END +"
										+ " CASE WHEN cast(car.xnombre10 as varchar)IS NULL OR cast(car.xnombre10 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre10 as varchar) END "
										+ " as nombres," + " apart.xdescripcion as nom_apart" + " from "
										+ connSdic.translateTable("s_art_carac") + " art " + " inner join "
										+ connSdic.translateTable("s_caracteristicas")
										+ " car on art.xcaracteristica_id=car.xcaracteristica_id "
										+ " left outer join imp.s_caracteristicasmlg"
										+ " carmlg on carmlg.xcaracteristica_id=car.xcaracteristica_id" + " inner join "
										+ connSdic.translateTable("pl_articulos")
										+ " gen on gen.xarticulo_id = art.xarticulo_id and gen.xempresa_id = art.xempresa_id"
										+ " inner join " + connSdic.translateTable("s_carac_fam")
										+ " fam on fam.xempresa_id = art.xempresa_id and fam.xcaracteristica_id = car.xcaracteristica_id"
										+ " left outer join " + connSdic.translateTable("sul_art_listas")
										+ " lista on lista.xlista_id=car.xlista1 and art.xvalorlista1=lista.xlinea_id "
										+ " left outer join imp.sul_art_listasmlg mlg on mlg.xlista_id=lista.xlista_id and mlg.xlinea_id=lista.xlinea_id"
										+ " left outer join imp.s_apartados apart on apart.xapartado_id=car.xapartado_id"
										+ " where  art.xempresa_id='" + sEmpresa + "' and  art.xarticulo_id='"
										+ sArticulo + "'"
										+ " and gen.xfamilia_produc=fam.xfamilia_id and gen.xtecnologia = fam.xssfamilia_id"
										+ " and car.xbaja=0 " + " and car.xcaracteristica_id='" + sCaracteristicaEstado
										+ "'" + " and isnull(mlg.idioma," + iIdioma + ") = '" + iIdioma
										+ "' and isnull(carmlg.idioma," + iIdioma + ") = '" + iIdioma
										+ "' and art.xsituacion_dsp='" + sSituacion3 + "'";
							}
							if (!(sSituacion4 == null || sSituacion4.equals(""))) {
								sql += "union"
										+ " select carmlg.xdescripcion,isnull(carmlg.xnombre1,car.xnombre1)xnombre1, isnull(carmlg.xnombre2,car.xnombre2)xnombre2,art.xsituacion_dsp situacionArt,gen.xfamilia_produc,gen.xtecnologia,gen.xsituacion_dsp,car.xapartado_id,car.xtipo_valor,art.xempresa_id,art.xarticulo_id,art.xcaracteristica_id,mlg.xdescripcion"
										+ ",lista.xlista_id,lista.xfiltro_id, car.xtipo_valor,car.xlista1,case car.xtipo_valor "
										+ "when 0 then cast(art.xvalorpasa1 as varchar) "
										+ "when 1 then cast(mlg.xdescripcion as varchar) " + "when 2 then "
										+ "CASE WHEN cast(art.xvalortexto1 as varchar) IS NULL OR cast(art.xvalortexto1 as varchar)= '' THEN ''"
										+ " ELSE cast(art.xvalortexto1 as varchar)END +"
										+ "CASE WHEN cast(art.xvalortexto2 as varchar) IS NULL OR cast(art.xvalortexto2 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto2 as varchar)END +"
										+ "CASE WHEN cast(art.xvalortexto3 as varchar)IS NULL OR cast(art.xvalortexto3 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto3 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto4 as varchar)IS NULL OR cast(art.xvalortexto4 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto4 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto5 as varchar)IS NULL OR cast(art.xvalortexto5 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto5 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto6 as varchar)IS NULL OR cast(art.xvalortexto6 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto6 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto7 as varchar)IS NULL OR cast(art.xvalortexto7 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto7 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto8 as varchar)IS NULL OR cast(art.xvalortexto8 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto8 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto9 as varchar)IS NULL OR cast(art.xvalortexto9 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto9 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto10 as varchar)IS NULL OR cast(art.xvalortexto10 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto10 as varchar) END " + "when 3 then "
										+ "CASE WHEN cast(art.xvalorint1 as varchar) IS NULL OR cast(art.xvalorint1 as varchar)= '' THEN '' "
										+ "ELSE cast(art.xvalorint1 as varchar)END +"
										+ "CASE WHEN cast(art.xvalorint2 as varchar) IS NULL OR cast(art.xvalorint2 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalorint2 as varchar)END +"
										+ "CASE WHEN cast(art.xvalorint3 as varchar)IS NULL OR cast(art.xvalorint3 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalorint3 as varchar) END +"
										+ "CASE WHEN cast(art.xvalorint4 as varchar)IS NULL OR cast(art.xvalorint4 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalorint4 as varchar) END +"
										+ "CASE WHEN cast(art.xvalorint5 as varchar)IS NULL OR cast(art.xvalorint5 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalorint5 as varchar) END +"
										+ "CASE WHEN cast(art.xvalorint6 as varchar)IS NULL OR cast(art.xvalorint6 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalorint6 as varchar) END+"
										+ "CASE WHEN cast(art.xvalorint7 as varchar)IS NULL OR cast(art.xvalorint7 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalorint7 as varchar) END+"
										+ "CASE WHEN cast(art.xvalorint8 as varchar)IS NULL OR cast(art.xvalorint8 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalorint8 as varchar) END+"
										+ "CASE WHEN cast(art.xvalorint9 as varchar)IS NULL OR cast(art.xvalorint9 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalorint9 as varchar) END+"
										+ "CASE WHEN cast(art.xvalorint10 as varchar)IS NULL OR cast(art.xvalorint10 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalorint10 as varchar) END" + " when 4 then "
										+ "CASE WHEN cast(art.xvalordecimal1 as varchar) IS NULL OR cast(art.xvalordecimal1 as varchar)= '' "
										+ "THEN '' ELSE format(art.xvalordecimal1,'n','es-es')END +"
										+ "CASE WHEN cast(art.xvalordecimal2 as varchar) IS NULL OR cast(art.xvalordecimal2 as varchar)= ''"
										+ " THEN '' ELSE ' / ' + format(art.xvalordecimal2,'n','es-es')END +"
										+ "CASE WHEN cast(art.xvalordecimal3 as varchar)IS NULL OR cast(art.xvalordecimal3 as varchar)= ''"
										+ " THEN '' ELSE ' / ' + format(art.xvalordecimal3,'n','es-es') END +"
										+ "CASE WHEN cast(art.xvalordecimal4 as varchar)IS NULL OR cast(art.xvalordecimal4 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal4,'n','es-es') END +"
										+ "CASE WHEN cast(art.xvalordecimal5 as varchar)IS NULL OR cast(art.xvalordecimal5 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal5,'n','es-es') END +"
										+ "CASE WHEN cast(art.xvalordecimal6 as varchar)IS NULL OR cast(art.xvalordecimal6 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal6,'n','es-es') END+"
										+ "CASE WHEN cast(art.xvalordecimal7 as varchar)IS NULL OR cast(art.xvalordecimal7 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal7,'n','es-es') END+"
										+ "CASE WHEN cast(art.xvalordecimal8 as varchar)IS NULL OR cast(art.xvalordecimal8 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal8,'n','es-es') END+"
										+ "CASE WHEN cast(art.xvalordecimal9 as varchar)IS NULL OR cast(art.xvalordecimal9 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal9,'n','es-es') END+"
										+ "CASE WHEN cast(art.xvalordecimal10 as varchar)IS NULL OR cast(art.xvalordecimal10 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + format(art.xvalordecimal10,'n','es-es') END"
										+ " end as valores," + " case " + sEspecial4 + " when -1 then("
										+ "(CASE WHEN cast(art.xvalortexto1 as varchar) IS NULL OR cast(art.xvalortexto1 as varchar)= '' THEN ''"
										+ " ELSE cast(art.xvalortexto1 as varchar)END +"
										+ "CASE WHEN cast(art.xvalortexto2 as varchar) IS NULL OR cast(art.xvalortexto2 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto2 as varchar)END +"
										+ "CASE WHEN cast(art.xvalortexto3 as varchar)IS NULL OR cast(art.xvalortexto3 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto3 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto4 as varchar)IS NULL OR cast(art.xvalortexto4 as varchar)= '' THEN '' "
										+ "ELSE ' / ' + cast(art.xvalortexto4 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto5 as varchar)IS NULL OR cast(art.xvalortexto5 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto5 as varchar) END +"
										+ "CASE WHEN cast(art.xvalortexto6 as varchar)IS NULL OR cast(art.xvalortexto6 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalortexto6 as varchar) END )) else '' end"
										+ "  as valores2"
										+ ", CASE WHEN cast(car.xnombre1 as varchar) IS NULL OR cast(car.xnombre1  as varchar)= '' THEN '' ELSE cast(car.xnombre1  as varchar)END +"
										+ " CASE WHEN cast(car.xnombre2 as varchar) IS NULL OR cast(car.xnombre2  as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre2  as varchar)END +"
										+ " CASE WHEN cast(car.xnombre3  as varchar)IS NULL OR cast(car.xnombre3 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre3 as varchar) END +"
										+ " CASE WHEN cast(car.xnombre4 as varchar)IS NULL OR cast(car.xnombre4  as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre4  as varchar) END +"
										+ " CASE WHEN cast(car.xnombre5 as varchar)IS NULL OR cast(car.xnombre5 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre5 as varchar) END +"
										+ " CASE WHEN cast(car.xnombre6 as varchar)IS NULL OR cast(car.xnombre6 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre6 as varchar) END+"
										+ " CASE WHEN cast(car.xnombre7 as varchar)IS NULL OR cast(car.xnombre7 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre7 as varchar) END +"
										+ " CASE WHEN cast(car.xnombre8 as varchar)IS NULL OR cast(car.xnombre8 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre8 as varchar) END +"
										+ " CASE WHEN cast(car.xnombre9 as varchar)IS NULL OR cast(car.xnombre9 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre9 as varchar) END +"
										+ " CASE WHEN cast(car.xnombre10 as varchar)IS NULL OR cast(car.xnombre10 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre10 as varchar) END "
										+ " as nombres," + " apart.xdescripcion as nom_apart" + " from "
										+ connSdic.translateTable("s_art_carac") + " art " + " inner join "
										+ connSdic.translateTable("s_caracteristicas")
										+ " car on art.xcaracteristica_id=car.xcaracteristica_id "
										+ " left outer join imp.s_caracteristicasmlg"
										+ " carmlg on carmlg.xcaracteristica_id=car.xcaracteristica_id" + " inner join "
										+ connSdic.translateTable("pl_articulos")
										+ " gen on gen.xarticulo_id = art.xarticulo_id and gen.xempresa_id = art.xempresa_id"
										+ " inner join " + connSdic.translateTable("s_carac_fam")
										+ " fam on fam.xempresa_id = art.xempresa_id and fam.xcaracteristica_id = car.xcaracteristica_id"
										+ " left outer join " + connSdic.translateTable("sul_art_listas")
										+ " lista on lista.xlista_id=car.xlista1 and art.xvalorlista1=lista.xlinea_id "
										+ " left outer join imp.sul_art_listasmlg mlg on mlg.xlista_id=lista.xlista_id and mlg.xlinea_id=lista.xlinea_id"
										+ " left outer join imp.s_apartados apart on apart.xapartado_id=car.xapartado_id"
										+ " where  art.xempresa_id='" + sEmpresa + "' and  art.xarticulo_id='"
										+ sArticulo + "'"
										+ " and gen.xfamilia_produc=fam.xfamilia_id and gen.xtecnologia = fam.xssfamilia_id"
										+ " and car.xbaja=0 " + " and car.xcaracteristica_id='" + sCaracteristicaEstado
										+ "'" + " and isnull(mlg.idioma," + iIdioma + ") = '" + iIdioma
										+ "' and isnull(carmlg.idioma," + iIdioma + ") = '" + iIdioma
										+ "' and art.xsituacion_dsp='" + sSituacion4 + "'";
							}

							try (DAResultSet oResSimp = session.getConnectionData().openSQL(sql)) {
								String sCaracAnterior = "";
								int iContadorAnterior = 0;
								while (oResSimp.moveNext()) {
									String sSituacionCarac = oResSimp.getString("situacionArt");
									String sNombreApart = oResSimp.getString("nom_apart");
									String sApartado = oResSimp.getString("xapartado_id");

									try {
										if (!sApartado.equals("62")) {
											fmObject.getContainer("collap_" + sApartado).setCaption(sNombreApart);
										}
									} catch (Exception e) {
										continue;
									}
									String sSituacionColumna1 = "";
									String sSituacionColumna2 = "";
									String sSituacionColumna3 = "";
									String sSituacionColumna4 = "";
									String columna = getView(VIEWS.txtcolumnaestado1).getValue();
									if (!(columna == null || columna.equals(""))) {
										String[] datos = columna.split("-");
										sSituacionColumna1 = datos[0];
									}
									columna = getView(VIEWS.txtcolumnaestado2).getValue();
									if (!(columna == null || columna.equals(""))) {
										String[] datos = columna.split("-");
										sSituacionColumna2 = datos[0];
									}
									columna = getView(VIEWS.txtcolumnaestado3).getValue();
									if (!(columna == null || columna.equals(""))) {
										String[] datos = columna.split("-");
										sSituacionColumna3 = datos[0];
									}
									columna = getView(VIEWS.txtcolumnaestado4).getValue();
									if (!(columna == null || columna.equals(""))) {
										String[] datos = columna.split("-");
										sSituacionColumna4 = datos[0];
									}
									String sNombre1 = oResSimp.getString("xnombre1");
									String sNombre2 = oResSimp.getString("xnombre2");

									valores = oResSimp.getString("valores");
									nombres = oResSimp.getString("nombres");
									String sDescripcion = oResSimp.getString("xdescripcion");
									String sCaracteristicas = oResSimp.getString("xcaracteristica_id");

									String sTipo = oResSimp.getString("xtipo_valor");
									sApartado = oResSimp.getString("xapartado_id");
									if (!(sApartado == null || sApartado.equals(""))) {
										if (sApartado.equals("62")) {
											continue;
										}
										// Filtramos por tipo de apartado

										// product information
										String sNombreCol = "";
										String sNombreCarac = "";
										int iContadorGenerico = 0;
										boolean imagenInsertada = false;
										try {
											sNombreCol = ApartadoEnum.valueOf("Apart_" + sApartado).nombreValor;
											sNombreCarac = ApartadoEnum
													.valueOf("Apart_" + sApartado).caracteristicaValor;
											imagenInsertada = ApartadoEnum
													.valueOf("Apart_" + sApartado).imagenInsertada;
											try {
												if (imagenInsertada == false) {
													sql = "select ximagen from "
															+ connSdic.translateTable("s_imagenes_dsp")
															+ " where xarticulo_id='" + sArticulo + "'"
															+ " and xapartado_id='" + sApartado + "'";
													oResSimp2 = connData.openSQL(sql);
													if (oResSimp2.moveNext()) {
														String imagenCod = oResSimp2.getString("ximagen");
														byte[] barr = Base64.getDecoder().decode(imagenCod);

														getItem(ITEMS.valueOf("txtfoto_" + sNombreCarac))
																.setValue(barr);

													}
													oResSimp2.close();
													ApartadoEnum.valueOf("Apart_" + sApartado).setImagenInsertada(true);
												}
											} catch (Exception e) {
												e.printStackTrace();
											}

											if (!sCaracAnterior.equals(sCaracteristicas)) {
												iContadorGenerico = ApartadoEnum.valueOf("Apart_" + sApartado).contador;
												ApartadoEnum.valueOf("Apart_" + sApartado).setContador(
														ApartadoEnum.valueOf("Apart_" + sApartado).contador + 1);
												iContadorAnterior = iContadorGenerico;
											}

										} catch (Exception e) {
											continue;
										}

										if (!(sEstados.contains(sSituacionColumna1))) {
											getItem(ITEMS.valueOf("txtvalormaestro_" + sNombreCol))
													.setValue(iContadorAnterior, "No aplica");
										}
										if (!(sEstados.contains(sSituacionColumna2))) {
											getItem(ITEMS.valueOf("txtvalormaestro_" + sNombreCol + 2))
													.setValue(iContadorAnterior, "No aplica");
										}
										if (!(sEstados.contains(sSituacionColumna3))) {
											getItem(ITEMS.valueOf("txtvalormaestro_" + sNombreCol + 3))
													.setValue(iContadorAnterior, "No aplica");
										}
										if (!(sEstados.contains(sSituacionColumna4))) {
											getItem(ITEMS.valueOf("txtvalormaestro_" + sNombreCol + 4))
													.setValue(iContadorAnterior, "No aplica");
										}

										HashMap<Integer, String> listaSituaciones = new HashMap<Integer, String>();
										listaSituaciones.put(1, sSituacionColumna1);
										listaSituaciones.put(2, sSituacionColumna2);
										listaSituaciones.put(3, sSituacionColumna3);
										listaSituaciones.put(4, sSituacionColumna4);
										String sNombreNom = sNombreCol;
										for (int z = 1; z < 5; z++) {
											String sSituacionMap = listaSituaciones.get(z);
											if (z != 1) {
												if (Character.isDigit(sNombreCol.charAt(sNombreCol.length() - 1)))
													sNombreCol = sNombreCol.substring(0, sNombreCol.length() - 1);
												sNombreCol = sNombreCol + z;
											}
											if (sSituacionMap.equals(sSituacionCarac)) {
												if (!(sNombreCol == null || sNombreCol.equals(""))) {
													if (sTipo.equals("0")) {
														if (!(nombres == null || nombres.equals(""))) {
															// getItem(ITEMS.valueOf("txtnombres_" + sNombreNom))
															// .setValue(iContadorAnterior, nombres);
														}
														if (valores.equals("0")) {
															getItem(ITEMS.valueOf("txtvalormaestro_" + sNombreCol))
																	.setValue(iContadorAnterior, sNombre2);
														} else {
															getItem(ITEMS.valueOf("txtvalormaestro_" + sNombreCol))
																	.setValue(iContadorAnterior, sNombre1);
														}
														getItem(ITEMS.valueOf("txtcaracteristica_" + sNombreCarac))
																.setValue(iContadorAnterior, sCaracteristicas);
														getItem(ITEMS.valueOf("txtcaracteristica_" + sNombreCarac))
																.setDescription(iContadorAnterior, sDescripcion);
													} else {
														if (!(nombres == null || nombres.equals(""))) {
															// getItem(ITEMS.valueOf("txtnombres_" + sNombreNom))
															// .setValue(iContadorAnterior, nombres);
														}
														if (!(valores == null || valores.equals(""))) {

															getItem(ITEMS.valueOf("txtvalormaestro_" + sNombreCol))
																	.setValue(iContadorAnterior, valores);

														} else {
															// getItem(ITEMS.valueOf("txtvalormaestro_" + sNombreCol))
															// .setValue(iContadorAnterior, "");

														}
														getItem(ITEMS.valueOf("txtcaracteristica_" + sNombreCarac))
																.setValue(iContadorAnterior, sCaracteristicas);
														getItem(ITEMS.valueOf("txtcaracteristica_" + sNombreCarac))
																.setDescription(iContadorAnterior, sDescripcion);
													}
												}
											}
											sCaracteristicasInsertadas += "," + sCaracteristicas;

										}

									}
									sCaracAnterior = sCaracteristicas;

								}

								oResSimp.close();
							} catch (Exception ot) {
								ot.printStackTrace();
								oResSimp.close();
								try {
									throw new PMException(session, ot);
								} catch (PMException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
			oRes3.close();

		} catch (Exception ot) {
			ot.printStackTrace();
			oRes3.close();
			try {
				throw new PMException(session, ot);
			} catch (PMException e) {
				e.printStackTrace();
			}
		}
		for (int r = 0; r < apartados.length; r++) {
			BOSegment iPanel = boObject.getSegment(SEGMENTS.valueOf(apartados[r].segment));
			iPanel.setAllowInsert(false);
		}

	}
