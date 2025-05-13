package form;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

/**
 * @author josegonzalez
 * 25/01/2023
 */
import com.unit4.ekon.crm.base_b.PMException;
import com.unit4.karat.apis.MultiLingual;
import com.unit4.karat.base.OTException;
import com.unit4.karat.bo.BOException;
import com.unit4.karat.bo.BOItem;
import com.unit4.karat.bo.BOSegment;
import com.unit4.karat.da.DAConnection;
import com.unit4.karat.da.DAConnectionSource;
import com.unit4.karat.da.DAException;
import com.unit4.karat.da.DAResultSet;
import com.unit4.karat.form.FMCombo;
import com.unit4.karat.form.FMEvent;
import com.unit4.karat.form.FMGrid;
import com.unit4.karat.form.FMObject;
import com.unit4.karat.form.FMWindow;
import com.unit4.karat.runtime.apis.systemlist.SystemList;
import com.unit4.karat.runtime.apis.systemlist.SystemListElement;
import com.unit4.karat.session.Session;
import com.unit4.karat.types.OTVariant;

import include.SUL_UTILS_ART;

public class s_articulos extends com.unit4.karat.form.FMDefaultEvents {
    public enum CONTAINERS {
        /** <b>Window class:</b> FMContainer.CONTAINER_WINDOW<br>
        * <b>Caption:</b> Seleccione el estado a borrar<br> */
        borrarDatos,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_CARD<br>
        * <b>Caption:</b> Busqueda<br> */
        card1,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> PRODUCT INFORMATION<br> */
        collap_01,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> CERTIFICATES<br> */
        collap_02,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> PACKAGING<br> */
        collap_03,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> COMPONENTS<br> */
        collap_04,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> PRODUCT TECHNICAL DATA<br> */
        collap_05,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> LED DATA<br> */
        collap_06,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> LED - MAIN LIGHT DATA SPHERE (ULBRICHT SPHERE)<br> */
        collap_07,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> MAIN LIGHT - DRIVER<br> */
        collap_08,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> CONTROL<br> */
        collap_09,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> FAN<br> */
        collap_10,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> DIMENSIONS (mm)<br> */
        collap_11,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> REMOTE CONTROL WORK<br> */
        collap_12,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> WORK TEST<br> */
        collap_13,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> DATOS CHEQUEO<br> */
        collap_14,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> AQL<br> */
        collap_15,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> CUERPO / CARCASA<br> */
        collap_16,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> PALAS<br> */
        collap_17,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> PLATO DE LUZ<br> */
        collap_18,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> DIFUSOR<br> */
        collap_19,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> EMBELLECEDOR SUPERIOR FLORON<br> */
        collap_20,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> EMBELLECEDOR INFERIOR FLORON<br> */
        collap_21,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> TIJA+ BOLA<br> */
        collap_22,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> TIJA<br> */
        collap_23,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> TULIPA<br> */
        collap_24,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> BASE<br> */
        collap_25,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> FLORON<br> */
        collap_26,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> EMBELLECEDOR<br> */
        collap_27,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> ARO<br> */
        collap_28,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> CABLE<br> */
        collap_29,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> REFLECTOR<br> */
        collap_30,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> LENTE<br> */
        collap_31,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> TEST COMPONENTS<br> */
        collap_32,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> EMBELLECEDOR SUP.MOTOR<br> */
        collap_33,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> EMBELLECEDOR INF.MOTOR<br> */
        collap_34,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> LAMP HOLDER<br> */
        collap_35,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> IOT<br> */
        collap_38,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> SENSOR<br> */
        collap_39,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> BATTERY<br> */
        collap_40,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> SPEAKER<br> */
        collap_41,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> SPRAY/HUMIDIFIER<br> */
        collap_42,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> CEILING PROJECTOR<br> */
        collap_43,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> ROTATING GRILL<br> */
        collap_44,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> PARTICLE FILTER<br> */
        collap_45,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> HEATER/HEATED BLADES<br> */
        collap_46,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> BLADES WITH ROTARY AXIS<br> */
        collap_47,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> IONIZER<br> */
        collap_48,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> CAMERA<br> */
        collap_49,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> ASSEMBLY TEST<br> */
        collap_50,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> SULION APP ANDROID<br> */
        collap_52,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> SULION APP IOS<br> */
        collap_53,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> ALEXA ASSIST.ANDROID<br> */
        collap_54,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> ALEXA ASSIST.IOS<br> */
        collap_55,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> GOOGLE ASSIST.ANDROID<br> */
        collap_56,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> GOOGLE ASSIST.IOS<br> */
        collap_57,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> EPREL<br> */
        collap_58,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> TEST DESTRUCTIVOS<br> */
        collap_59,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> BRACKET<br> */
        collap_60,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> LUZ PRINCIPAL<br> */
        collap_61,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> LUZ SECUNDARIA<br> */
        collap_63,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> collap2<br> */
        collap_link1,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> collap3<br> */
        collap_link2,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> collap4<br> */
        collap_link3,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> collap5<br> */
        collap_link4,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> collap2<br> */
        collap_link5,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> collap3<br> */
        collap_link6,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> collap4<br> */
        collap_link7,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> collap5<br> */
        collap_link8,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> collap6<br> */
        collap_link9,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> Filtro<br> */
        collap1,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> Datos articulo<br> */
        collap14,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_WINDOW<br>
        * <b>Caption:</b> Duplicar Datos del Articulo<br> */
        duplicarArticulo,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_WINDOW<br>
        * <b>Caption:</b> Duplicar Datos<br> */
        duplicarValores,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> Comparar<br> */
        framecomparar,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> Numeros Decimales<br> */
        framedecimales,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> Numeros Enteros<br> */
        frameintegers,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> Listas<br> */
        framelistas,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br> */
        framepaneles,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> Pasa / No Pasa<br> */
        framepasa,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br> */
        framesituacion,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br>
        * <b>Caption:</b> Textos<br> */
        frametexto,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_FRAME<br> */
        frcuerpo,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_01,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_02,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_03,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_04,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_05,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_06,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_07,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_08,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_09,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_10,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_11,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_12,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_13,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_14,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_15,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_16,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_17,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_18,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_19,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_20,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_21,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_22,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_23,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_24,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_25,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_26,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_27,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_28,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_29,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_30,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_31,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_32,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_33,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_34,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_35,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_38,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_39,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_40,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_41,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_42,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_43,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_44,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_45,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_46,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_47,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_48,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_49,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_50,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_52,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_53,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_54,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_55,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_56,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_57,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_58,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_59,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_60,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_61,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_63,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_link1,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_link2,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_link3,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_link4,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_link5,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_link6,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_link7,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_link8,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_GRID<br> */
        grd_link9,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_WINDOW<br> */
        introduceDatos,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_CARDINDEX<br> */
        K__MAINCARD,		//NOSONAR
        /** <b>Window class:</b> FMContainer.CONTAINER_WINDOW<br>
        * <b>Caption:</b> DSP - Articulos<br> */
        s_articulos		//NOSONAR
    }

    public enum VIEWS {
        /** <b>Caption:</b> Situación a borrar<br>
        * <b>View Type:</b> FMView.VIEW_DROPLIST<br> */
        aux_estado,		//NOSONAR
        /** <b>Caption:</b> Descripcion<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        auxdescripcion,		//NOSONAR
        /** <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        checknopasa,		//NOSONAR
        /** <b>Caption:</b> Packaging<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        checkpackaging,		//NOSONAR
        /** <b>Caption:</b> Básica<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkbasica,		//NOSONAR
        /** <b>Caption:</b> Certificados<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkcertificados,		//NOSONAR
        /** <b>Caption:</b> Comercial<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkcomercial,		//NOSONAR
        /** <b>Caption:</b> Components<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkcomponents,		//NOSONAR
        /** <b>Caption:</b> Control<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkcontrol,		//NOSONAR
        /** <b>Caption:</b> Datos chequeo<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkdatoschequeo,		//NOSONAR
        /** <b>Caption:</b> Dimensions<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkdimensions,		//NOSONAR
        /** <b>Caption:</b> Main light - Driver<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkdriver,		//NOSONAR
        /** <b>Caption:</b> Fan<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkfan,		//NOSONAR
        /** <b>Caption:</b> General<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkgeneral,		//NOSONAR
        /** <b>Caption:</b> Inspección<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkinspeccion,		//NOSONAR
        /** <b>Caption:</b> Led data<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkled,		//NOSONAR
        /** <b>Caption:</b> Led Main<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkledmain,		//NOSONAR
        /** <b>Caption:</b> Mass Productión<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkmass,		//NOSONAR
        /** <b>Caption:</b> Muestra<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkmuestra,		//NOSONAR
        /** <b>Caption:</b> Product information<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkproductinf,		//NOSONAR
        /** <b>Caption:</b> Remote Control<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chkremote,		//NOSONAR
        /** <b>Caption:</b> Work test<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        chktest,		//NOSONAR
        /** <b>Caption:</b> Aceptar<br>
        * <b>View Type:</b> FMView.VIEW_BUTTON<br> */
        cmd_aceptarborrado,		//NOSONAR
        /** <b>Caption:</b> Borrar datos estado<br>
        * <b>View Type:</b> FMView.VIEW_BUTTON<br> */
        cmd_borrar,		//NOSONAR
        /** <b>Caption:</b> Pasar a sig.situacion<br>
        * <b>View Type:</b> FMView.VIEW_BUTTON<br> */
        cmd_cambiarsituacion,		//NOSONAR
        /** <b>Caption:</b> Cancelar<br>
        * <b>View Type:</b> FMView.VIEW_BUTTON<br> */
        cmd_cancelarborrado,		//NOSONAR
        /** <b>Caption:</b> Aceptar<br>
        * <b>View Type:</b> FMView.VIEW_BUTTON<br> */
        cmdaceptar,		//NOSONAR
        /** <b>Caption:</b> Borrar datos<br>
        * <b>View Type:</b> FMView.VIEW_BUTTON<br> */
        cmdborrardatos,		//NOSONAR
        /** <b>Caption:</b> Cancelar<br>
        * <b>View Type:</b> FMView.VIEW_BUTTON<br> */
        cmdcancelar,		//NOSONAR
        /** <b>Caption:</b> Cancelar<br>
        * <b>View Type:</b> FMView.VIEW_BUTTON<br> */
        cmdcancelardup,		//NOSONAR
        /** <b>Caption:</b> Cancelar<br>
        * <b>View Type:</b> FMView.VIEW_BUTTON<br> */
        cmdcancelarrart,		//NOSONAR
        /** <b>Caption:</b> Cargar Datos<br>
        * <b>View Type:</b> FMView.VIEW_BUTTON<br> */
        cmdcargardatos,		//NOSONAR
        /** <b>Caption:</b> Buscar descripcion<br>
        * <b>View Type:</b> FMView.VIEW_BUTTON<br> */
        cmddescripcion,		//NOSONAR
        /** <b>Caption:</b> Duplicar<br>
        * <b>View Type:</b> FMView.VIEW_BUTTON<br> */
        cmdduplicar,		//NOSONAR
        /** <b>Caption:</b> Duplicar datos<br>
        * <b>View Type:</b> FMView.VIEW_BUTTON<br> */
        cmdduplicarart,		//NOSONAR
        /** <b>Caption:</b> Duplicar Valores Estado<br>
        * <b>View Type:</b> FMView.VIEW_BUTTON<br> */
        cmdduplicardatos,		//NOSONAR
        /** <b>Caption:</b> Duplicar Valores Artículo<br>
        * <b>View Type:</b> FMView.VIEW_BUTTON<br> */
        cmdduplicardatosart,		//NOSONAR
        /** <b>View Type:</b> FMView.VIEW_LABEL<br> */
        lblmensaje,		//NOSONAR
        /** <b>Caption:</b> Nombre1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        textbox1,		//NOSONAR
        /** <b>Caption:</b> Nombre 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        textbox10,		//NOSONAR
        /** <b>Caption:</b> Nombre 5<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        textbox11,		//NOSONAR
        /** <b>Caption:</b> Nombre 6<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        textbox12,		//NOSONAR
        /** <b>Caption:</b> Nombre1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        textbox13,		//NOSONAR
        /** <b>Caption:</b> Nombre1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        textbox14,		//NOSONAR
        /** <b>Caption:</b> Nombre2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        textbox2,		//NOSONAR
        /** <b>Caption:</b> Nombre 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        textbox3,		//NOSONAR
        /** <b>Caption:</b> Nombre 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        textbox4,		//NOSONAR
        /** <b>Caption:</b> Nombre 5<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        textbox5,		//NOSONAR
        /** <b>Caption:</b> Nombre 6<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        textbox6,		//NOSONAR
        /** <b>Caption:</b> Nombre1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        textbox7,		//NOSONAR
        /** <b>Caption:</b> Nombre2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        textbox8,		//NOSONAR
        /** <b>Caption:</b> Nombre 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        textbox9,		//NOSONAR
        /** <b>Caption:</b> Code of the item<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtarticulo_id,		//NOSONAR
        /** <b>Caption:</b> Copiar datos a<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtarticulo_id_dup,		//NOSONAR
        /** <b>Caption:</b> Copiar datos de<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtarticulo_id_duplica,		//NOSONAR
        /** <b>Caption:</b> grd_55_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_alei,		//NOSONAR
        /** <b>Caption:</b> grd_54_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_alex,		//NOSONAR
        /** <b>Caption:</b> grd_52_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_appa,		//NOSONAR
        /** <b>Caption:</b> grd_53_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_appi,		//NOSONAR
        /** <b>Caption:</b> grd_15_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_aql,		//NOSONAR
        /** <b>Caption:</b> grd_28_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_aro,		//NOSONAR
        /** <b>Caption:</b> grd_50_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_asse,		//NOSONAR
        /** <b>Caption:</b> grd_25_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_base,		//NOSONAR
        /** <b>Caption:</b> grd_40_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_bate,		//NOSONAR
        /** <b>Caption:</b> grd_46_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_blad,		//NOSONAR
        /** <b>Caption:</b> grd_60_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_brac,		//NOSONAR
        /** <b>Caption:</b> grd_29_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_cabl,		//NOSONAR
        /** <b>Caption:</b> grd_49_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_came,		//NOSONAR
        /** <b>Caption:</b> grd_16_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_ccar,		//NOSONAR
        /** <b>Caption:</b> grd_43_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_ceil,		//NOSONAR
        /** <b>Caption:</b> Caracteristica<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_certif,		//NOSONAR
        /** <b>Caption:</b> Caracteristica<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_comp,		//NOSONAR
        /** <b>Caption:</b> Caracteristica<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_control,		//NOSONAR
        /** <b>Caption:</b> Caracteristica<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_dat_che,		//NOSONAR
        /** <b>Caption:</b> grd_19_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_dif,		//NOSONAR
        /** <b>Caption:</b> Caracteristica<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_dimen,		//NOSONAR
        /** <b>Caption:</b> Caracteristica<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_driver,		//NOSONAR
        /** <b>Caption:</b> grd_34_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_eim,		//NOSONAR
        /** <b>Caption:</b> grd_27_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_embe,		//NOSONAR
        /** <b>Caption:</b> grd_21_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_embi,		//NOSONAR
        /** <b>Caption:</b> grd_20_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_embs,		//NOSONAR
        /** <b>Caption:</b> grd_58_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_eprl,		//NOSONAR
        /** <b>Caption:</b> grd_33_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_esm,		//NOSONAR
        /** <b>Caption:</b> Caracteristica<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_fan,		//NOSONAR
        /** <b>Caption:</b> grd_26_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_flor,		//NOSONAR
        /** <b>Caption:</b> Caracteristica<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_gen,		//NOSONAR
        /** <b>Caption:</b> grd_56_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_goga,		//NOSONAR
        /** <b>Caption:</b> grd_57_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_gogi,		//NOSONAR
        /** <b>Caption:</b> grd_44_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_gril,		//NOSONAR
        /** <b>Caption:</b> grd_48_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_ioni,		//NOSONAR
        /** <b>Caption:</b> grd_38_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_iot,		//NOSONAR
        /** <b>Caption:</b> grd_35_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_lamp,		//NOSONAR
        /** <b>Caption:</b> Caracteristica<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_led,		//NOSONAR
        /** <b>Caption:</b> Caracteristica<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_ledmain,		//NOSONAR
        /** <b>Caption:</b> grd_31_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_lent,		//NOSONAR
        /** <b>Caption:</b> grd_link1_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_link1,		//NOSONAR
        /** <b>Caption:</b> grd_link2_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_link2,		//NOSONAR
        /** <b>Caption:</b> grd_link3_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_link3,		//NOSONAR
        /** <b>Caption:</b> grd_link4_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_link4,		//NOSONAR
        /** <b>Caption:</b> grd_link5_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_link5,		//NOSONAR
        /** <b>Caption:</b> grd_link6_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_link6,		//NOSONAR
        /** <b>Caption:</b> grd_link7_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_link7,		//NOSONAR
        /** <b>Caption:</b> grd_link8_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_link8,		//NOSONAR
        /** <b>Caption:</b> grd_link9_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_link9,		//NOSONAR
        /** <b>Caption:</b> Caracteristica<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_lprin,		//NOSONAR
        /** <b>Caption:</b> Caracteristica<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_lsec,		//NOSONAR
        /** <b>Caption:</b> Caracteristica<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_pack,		//NOSONAR
        /** <b>Caption:</b> grd_17_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_pala,		//NOSONAR
        /** <b>Caption:</b> grd_45_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_part,		//NOSONAR
        /** <b>Caption:</b> grd_18_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_plat,		//NOSONAR
        /** <b>Caption:</b> Caracteristica<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_prod_in,		//NOSONAR
        /** <b>Caption:</b> grd_47_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_raxi,		//NOSONAR
        /** <b>Caption:</b> grd_30_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_refl,		//NOSONAR
        /** <b>Caption:</b> Caracteristica<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_remote,		//NOSONAR
        /** <b>Caption:</b> grd_39_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_sens,		//NOSONAR
        /** <b>Caption:</b> grd_41_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_spe,		//NOSONAR
        /** <b>Caption:</b> grd_42_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_spr,		//NOSONAR
        /** <b>Caption:</b> grdtcomp_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_tcomp,		//NOSONAR
        /** <b>Caption:</b> grd_59_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_tdes,		//NOSONAR
        /** <b>Caption:</b> Caracteristica<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_test,		//NOSONAR
        /** <b>Caption:</b> grd_22_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_tibo,		//NOSONAR
        /** <b>Caption:</b> grd_23_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_tija,		//NOSONAR
        /** <b>Caption:</b> grd_24_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtcaracteristica_tuli,		//NOSONAR
        /** <b>Caption:</b> Columna 1<br>
        * <b>View Type:</b> FMView.VIEW_DROPLIST<br> */
        txtcolumnaestado1,		//NOSONAR
        /** <b>Caption:</b> Columna 2<br>
        * <b>View Type:</b> FMView.VIEW_DROPLIST<br> */
        txtcolumnaestado2,		//NOSONAR
        /** <b>Caption:</b> Columna 3<br>
        * <b>View Type:</b> FMView.VIEW_DROPLIST<br> */
        txtcolumnaestado3,		//NOSONAR
        /** <b>Caption:</b> Columna 4<br>
        * <b>View Type:</b> FMView.VIEW_DROPLIST<br> */
        txtcolumnaestado4,		//NOSONAR
        /** <b>Caption:</b> Familia DSP<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtfamilia_produc,		//NOSONAR
        /** <b>Caption:</b> Fecha Modifica Calidad<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtfech_mod_calidad,		//NOSONAR
        /** <b>Caption:</b> Fecha modifica producto<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtfech_mod_producto,		//NOSONAR
        /** <b>View Type:</b> FMView.VIEW_PICTURE<br> */
        txtfoto_control,		//NOSONAR
        /** <b>View Type:</b> FMView.VIEW_PICTURE<br> */
        txtfoto_dimen,		//NOSONAR
        /** <b>Caption:</b> Foto Info<br>
        * <b>View Type:</b> FMView.VIEW_PICTURE<br> */
        txtfotoinfo,		//NOSONAR
        /** <b>Caption:</b> Info<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtinfo,		//NOSONAR
        /** <b>Caption:</b> Modificado Calidad<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        txtmod_calidad,		//NOSONAR
        /** <b>Caption:</b> Modificado Producto<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        txtmod_producto,		//NOSONAR
        /** <b>Caption:</b> grd_48_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombre_ioni,		//NOSONAR
        /** <b>Caption:</b> Nombre 10<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombre10,		//NOSONAR
        /** <b>Caption:</b> Nombre 10<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombre10e,		//NOSONAR
        /** <b>Caption:</b> Nombre 10<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombre10t,		//NOSONAR
        /** <b>Caption:</b> Nombre2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombre2,		//NOSONAR
        /** <b>Caption:</b> Nombre 7<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombre7,		//NOSONAR
        /** <b>Caption:</b> Nombre 7<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombre7d,		//NOSONAR
        /** <b>Caption:</b> Nombre 7<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombre7e,		//NOSONAR
        /** <b>Caption:</b> Nombre 8<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombre8,		//NOSONAR
        /** <b>Caption:</b> Nombre 8<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombre8d,		//NOSONAR
        /** <b>Caption:</b> Nombre 8<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombre8e,		//NOSONAR
        /** <b>Caption:</b> Nombre 9<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombre9,		//NOSONAR
        /** <b>Caption:</b> Nombre 9<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombre9d,		//NOSONAR
        /** <b>Caption:</b> Nombre 9<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombre9e,		//NOSONAR
        /** <b>Caption:</b> grd_55_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_alei,		//NOSONAR
        /** <b>Caption:</b> grd_54_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_alex,		//NOSONAR
        /** <b>Caption:</b> grd_52_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_appa,		//NOSONAR
        /** <b>Caption:</b> grd_53_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_appi,		//NOSONAR
        /** <b>Caption:</b> grd_15_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_aql,		//NOSONAR
        /** <b>Caption:</b> grd_28_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_aro,		//NOSONAR
        /** <b>Caption:</b> grd_50_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_asse,		//NOSONAR
        /** <b>Caption:</b> grd_25_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_base,		//NOSONAR
        /** <b>Caption:</b> grd_40_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_bate,		//NOSONAR
        /** <b>Caption:</b> grd_46_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_blad,		//NOSONAR
        /** <b>Caption:</b> grd_60_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_brac,		//NOSONAR
        /** <b>Caption:</b> grd_29_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_cabl,		//NOSONAR
        /** <b>Caption:</b> grd_49_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_came,		//NOSONAR
        /** <b>Caption:</b> grd_16_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_ccar,		//NOSONAR
        /** <b>Caption:</b> grd_43_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_ceil,		//NOSONAR
        /** <b>Caption:</b> Nombres<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_certif,		//NOSONAR
        /** <b>Caption:</b> Nombres<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_comp,		//NOSONAR
        /** <b>Caption:</b> Nombres<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_control,		//NOSONAR
        /** <b>Caption:</b> Nombres<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_dat_chec,		//NOSONAR
        /** <b>Caption:</b> grd_19_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_dif,		//NOSONAR
        /** <b>Caption:</b> Nombres<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_dimen,		//NOSONAR
        /** <b>Caption:</b> Nombres<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_driver,		//NOSONAR
        /** <b>Caption:</b> grd_34_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_eim,		//NOSONAR
        /** <b>Caption:</b> grd_27_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_embe,		//NOSONAR
        /** <b>Caption:</b> grd_21_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_embi,		//NOSONAR
        /** <b>Caption:</b> grd_20_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_embs,		//NOSONAR
        /** <b>Caption:</b> grd_58_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_eprl,		//NOSONAR
        /** <b>Caption:</b> grd_33_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_esm,		//NOSONAR
        /** <b>Caption:</b> Nombres<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_fan,		//NOSONAR
        /** <b>Caption:</b> grd_26_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_flor,		//NOSONAR
        /** <b>Caption:</b> Nombres<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_gen,		//NOSONAR
        /** <b>Caption:</b> grd_56_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_goga,		//NOSONAR
        /** <b>Caption:</b> grd_57_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_gogi,		//NOSONAR
        /** <b>Caption:</b> grd_44_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_gril,		//NOSONAR
        /** <b>Caption:</b> grd_38_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_iot,		//NOSONAR
        /** <b>Caption:</b> grd_35_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_lamp,		//NOSONAR
        /** <b>Caption:</b> Nombres<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_led,		//NOSONAR
        /** <b>Caption:</b> Nombres<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_ledmain,		//NOSONAR
        /** <b>Caption:</b> grd_31_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_lent,		//NOSONAR
        /** <b>Caption:</b> grd_link1_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_link1,		//NOSONAR
        /** <b>Caption:</b> grd_link2_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_link2,		//NOSONAR
        /** <b>Caption:</b> grd_link3_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_link3,		//NOSONAR
        /** <b>Caption:</b> grd_link4_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_link4,		//NOSONAR
        /** <b>Caption:</b> grd_link5_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_link5,		//NOSONAR
        /** <b>Caption:</b> grd_link6_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_link6,		//NOSONAR
        /** <b>Caption:</b> grd_link7_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_link7,		//NOSONAR
        /** <b>Caption:</b> grd_link8_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_link8,		//NOSONAR
        /** <b>Caption:</b> grd_link9_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_link9,		//NOSONAR
        /** <b>Caption:</b> grd_61_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_lprin,		//NOSONAR
        /** <b>Caption:</b> grd_63_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_lsec,		//NOSONAR
        /** <b>Caption:</b> Nombres<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_pack,		//NOSONAR
        /** <b>Caption:</b> grd_17_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_pala,		//NOSONAR
        /** <b>Caption:</b> grd_45_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_part,		//NOSONAR
        /** <b>Caption:</b> grd_18_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_plat,		//NOSONAR
        /** <b>Caption:</b> Nombres<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_prod_inf,		//NOSONAR
        /** <b>Caption:</b> grd_47_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_raxi,		//NOSONAR
        /** <b>Caption:</b> grd_30_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_refl,		//NOSONAR
        /** <b>Caption:</b> Nombres<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_remote,		//NOSONAR
        /** <b>Caption:</b> grd_39_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_sens,		//NOSONAR
        /** <b>Caption:</b> grd_41_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_spe,		//NOSONAR
        /** <b>Caption:</b> grd_42_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_spr,		//NOSONAR
        /** <b>Caption:</b> grdtcomp_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_tcomp,		//NOSONAR
        /** <b>Caption:</b> grd_59_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_tdes,		//NOSONAR
        /** <b>Caption:</b> Nombres<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_test,		//NOSONAR
        /** <b>Caption:</b> grd_22_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_tibo,		//NOSONAR
        /** <b>Caption:</b> grd_23_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_tija,		//NOSONAR
        /** <b>Caption:</b> grd_24_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombres_tuli,		//NOSONAR
        /** <b>Caption:</b> Nombre1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombretexto1,		//NOSONAR
        /** <b>Caption:</b> Nombre2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombretexto2,		//NOSONAR
        /** <b>Caption:</b> Nombre 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombretexto3,		//NOSONAR
        /** <b>Caption:</b> Nombre 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombretexto4,		//NOSONAR
        /** <b>Caption:</b> Nombre 5<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombretexto5,		//NOSONAR
        /** <b>Caption:</b> Nombre 6<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtnombretexto6,		//NOSONAR
        /** <b>Caption:</b> Situación DSP<br>
        * <b>View Type:</b> FMView.VIEW_DROPLIST<br> */
        txtsituacion_dsp_gen,		//NOSONAR
        /** <b>Caption:</b> Datos Destino<br>
        * <b>View Type:</b> FMView.VIEW_DROPLIST<br> */
        txtsituaciondestino,		//NOSONAR
        /** <b>Caption:</b> Datos Origen<br>
        * <b>View Type:</b> FMView.VIEW_DROPLIST<br> */
        txtsituacionorigen,		//NOSONAR
        /** <b>Caption:</b> Subfamilia DSP<br>
        * <b>View Type:</b> FMView.VIEW_DROPLIST<br> */
        txttecnologia,		//NOSONAR
        /** <b>Caption:</b> User Quality<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtusu_mod_calidad,		//NOSONAR
        /** <b>Caption:</b> User Product<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtusu_mod_producto,		//NOSONAR
        /** <b>Caption:</b> grd_link8_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalomaestro_link81,		//NOSONAR
        /** <b>Caption:</b> grd_link8_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalomaestro_link82,		//NOSONAR
        /** <b>Caption:</b> grd_link8_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalomaestro_link83,		//NOSONAR
        /** <b>Caption:</b> grd_link8_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalomaestro_link84,		//NOSONAR
        /** <b>Caption:</b> grd_link9_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalomaestro_link91,		//NOSONAR
        /** <b>Caption:</b> grd_link9_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalomaestro_link92,		//NOSONAR
        /** <b>Caption:</b> grd_link9_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalomaestro_link93,		//NOSONAR
        /** <b>Caption:</b> grd_link9_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalomaestro_link94,		//NOSONAR
        /** <b>Caption:</b> Decimal 1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalordecimal1,		//NOSONAR
        /** <b>Caption:</b> Decimal 10<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalordecimal10,		//NOSONAR
        /** <b>Caption:</b> Decimal 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalordecimal2,		//NOSONAR
        /** <b>Caption:</b> Decimal 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalordecimal3,		//NOSONAR
        /** <b>Caption:</b> Decimal 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalordecimal4,		//NOSONAR
        /** <b>Caption:</b> Decimal 5<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalordecimal5,		//NOSONAR
        /** <b>Caption:</b> Decimal 6<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalordecimal6,		//NOSONAR
        /** <b>Caption:</b> Decimal 7<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalordecimal7,		//NOSONAR
        /** <b>Caption:</b> Decimal 8<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalordecimal8,		//NOSONAR
        /** <b>Caption:</b> Decimal 9<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalordecimal9,		//NOSONAR
        /** <b>Caption:</b> Numero 1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalorint1,		//NOSONAR
        /** <b>Caption:</b> Numero 10<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalorint10,		//NOSONAR
        /** <b>Caption:</b> Numero 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalorint2,		//NOSONAR
        /** <b>Caption:</b> Numero 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalorint3,		//NOSONAR
        /** <b>Caption:</b> Numero 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalorint4,		//NOSONAR
        /** <b>Caption:</b> Numero 5<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalorint5,		//NOSONAR
        /** <b>Caption:</b> Numero 6<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalorint6,		//NOSONAR
        /** <b>Caption:</b> Numero 7<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalorint7,		//NOSONAR
        /** <b>Caption:</b> Numero 8<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalorint8,		//NOSONAR
        /** <b>Caption:</b> Numero 9<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalorint9,		//NOSONAR
        /** <b>Caption:</b> Label<br>
        * <b>View Type:</b> FMView.VIEW_DROPLIST<br> */
        txtvalorlista1,		//NOSONAR
        /** <b>Caption:</b> grd_55_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_alei,		//NOSONAR
        /** <b>Caption:</b> grd_55_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_alei2,		//NOSONAR
        /** <b>Caption:</b> grd_55_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_alei3,		//NOSONAR
        /** <b>Caption:</b> grd_55_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_alei4,		//NOSONAR
        /** <b>Caption:</b> grd_54_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_alex,		//NOSONAR
        /** <b>Caption:</b> grd_54_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_alex2,		//NOSONAR
        /** <b>Caption:</b> grd_54_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_alex3,		//NOSONAR
        /** <b>Caption:</b> grd_54_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_alex4,		//NOSONAR
        /** <b>Caption:</b> grd_52_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_appa,		//NOSONAR
        /** <b>Caption:</b> grd_52_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_appa2,		//NOSONAR
        /** <b>Caption:</b> grd_52_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_appa3,		//NOSONAR
        /** <b>Caption:</b> grd_52_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_appa4,		//NOSONAR
        /** <b>Caption:</b> grd_53_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_appi,		//NOSONAR
        /** <b>Caption:</b> grd_53_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_appi2,		//NOSONAR
        /** <b>Caption:</b> grd_53_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_appi3,		//NOSONAR
        /** <b>Caption:</b> grd_53_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_appi4,		//NOSONAR
        /** <b>Caption:</b> grd_15_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_aql,		//NOSONAR
        /** <b>Caption:</b> grd_15_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_aql2,		//NOSONAR
        /** <b>Caption:</b> grd_15_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_aql3,		//NOSONAR
        /** <b>Caption:</b> grd_15_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_aql4,		//NOSONAR
        /** <b>Caption:</b> grd_28_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_aro,		//NOSONAR
        /** <b>Caption:</b> grd_28_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_aro2,		//NOSONAR
        /** <b>Caption:</b> grd_28_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_aro3,		//NOSONAR
        /** <b>Caption:</b> grd_28_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_aro4,		//NOSONAR
        /** <b>Caption:</b> grd_50_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_asse,		//NOSONAR
        /** <b>Caption:</b> grd_50_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_asse2,		//NOSONAR
        /** <b>Caption:</b> grd_50_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_asse3,		//NOSONAR
        /** <b>Caption:</b> grd_50_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_asse4,		//NOSONAR
        /** <b>Caption:</b> grd_25_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_base,		//NOSONAR
        /** <b>Caption:</b> grd_25_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_base2,		//NOSONAR
        /** <b>Caption:</b> grd_25_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_base3,		//NOSONAR
        /** <b>Caption:</b> grd_25_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_base4,		//NOSONAR
        /** <b>Caption:</b> grd_40_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_bate,		//NOSONAR
        /** <b>Caption:</b> grd_40_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_bate2,		//NOSONAR
        /** <b>Caption:</b> grd_40_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_bate3,		//NOSONAR
        /** <b>Caption:</b> grd_40_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_bate4,		//NOSONAR
        /** <b>Caption:</b> grd_46_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_blad,		//NOSONAR
        /** <b>Caption:</b> grd_46_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_blad2,		//NOSONAR
        /** <b>Caption:</b> grd_46_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_blad3,		//NOSONAR
        /** <b>Caption:</b> grd_46_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_blad4,		//NOSONAR
        /** <b>Caption:</b> grd_60_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_brac,		//NOSONAR
        /** <b>Caption:</b> grd_60_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_brac2,		//NOSONAR
        /** <b>Caption:</b> grd_60_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_brac3,		//NOSONAR
        /** <b>Caption:</b> grd_60_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_brac4,		//NOSONAR
        /** <b>Caption:</b> grd_29_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_cabl,		//NOSONAR
        /** <b>Caption:</b> grd_29_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_cabl2,		//NOSONAR
        /** <b>Caption:</b> grd_29_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_cabl3,		//NOSONAR
        /** <b>Caption:</b> grd_29_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_cabl4,		//NOSONAR
        /** <b>Caption:</b> grd_49_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_came,		//NOSONAR
        /** <b>Caption:</b> grd_49_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_came2,		//NOSONAR
        /** <b>Caption:</b> grd_49_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_came3,		//NOSONAR
        /** <b>Caption:</b> grd_49_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_came4,		//NOSONAR
        /** <b>Caption:</b> grd_16_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_ccar,		//NOSONAR
        /** <b>Caption:</b> grd_16_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_ccar2,		//NOSONAR
        /** <b>Caption:</b> grd_16_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_ccar3,		//NOSONAR
        /** <b>Caption:</b> grd_16_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_ccar4,		//NOSONAR
        /** <b>Caption:</b> grd_43_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_ceil,		//NOSONAR
        /** <b>Caption:</b> grd_43_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_ceil2,		//NOSONAR
        /** <b>Caption:</b> grd_43_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_ceil3,		//NOSONAR
        /** <b>Caption:</b> grd_43_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_ceil4,		//NOSONAR
        /** <b>Caption:</b> 0#BasicaValores<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_certif,		//NOSONAR
        /** <b>Caption:</b> Columna 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_certif2,		//NOSONAR
        /** <b>Caption:</b> Columna 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_certif3,		//NOSONAR
        /** <b>Caption:</b> Columna 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_certif4,		//NOSONAR
        /** <b>Caption:</b> 0#BasicaValores<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_comp,		//NOSONAR
        /** <b>Caption:</b> Columna 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_comp2,		//NOSONAR
        /** <b>Caption:</b> Columna 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_comp3,		//NOSONAR
        /** <b>Caption:</b> Columna 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_comp4,		//NOSONAR
        /** <b>Caption:</b> 0#BasicaValores<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_control,		//NOSONAR
        /** <b>Caption:</b> Columna 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_control2,		//NOSONAR
        /** <b>Caption:</b> Columna 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_control3,		//NOSONAR
        /** <b>Caption:</b> Columna 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_control4,		//NOSONAR
        /** <b>Caption:</b> 0#BasicaValores<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_dat_chec,		//NOSONAR
        /** <b>Caption:</b> Columna 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_dat_chec2,		//NOSONAR
        /** <b>Caption:</b> Columna 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_dat_chec3,		//NOSONAR
        /** <b>Caption:</b> Columna 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_dat_chec4,		//NOSONAR
        /** <b>Caption:</b> grd_19_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_dif,		//NOSONAR
        /** <b>Caption:</b> grd_19_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_dif2,		//NOSONAR
        /** <b>Caption:</b> grd_19_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_dif3,		//NOSONAR
        /** <b>Caption:</b> grd_19_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_dif4,		//NOSONAR
        /** <b>Caption:</b> 0#BasicaValores<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_dimen,		//NOSONAR
        /** <b>Caption:</b> Columna 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_dimen2,		//NOSONAR
        /** <b>Caption:</b> Columna 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_dimen3,		//NOSONAR
        /** <b>Caption:</b> Columna 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_dimen4,		//NOSONAR
        /** <b>Caption:</b> 0#BasicaValores<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_driver,		//NOSONAR
        /** <b>Caption:</b> Columna 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_driver2,		//NOSONAR
        /** <b>Caption:</b> Columna 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_driver3,		//NOSONAR
        /** <b>Caption:</b> Columna 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_driver4,		//NOSONAR
        /** <b>Caption:</b> grd_34_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_eim,		//NOSONAR
        /** <b>Caption:</b> grd_34_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_eim2,		//NOSONAR
        /** <b>Caption:</b> grd_34_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_eim3,		//NOSONAR
        /** <b>Caption:</b> grd_34_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_eim4,		//NOSONAR
        /** <b>Caption:</b> grd_27_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_embe,		//NOSONAR
        /** <b>Caption:</b> grd_27_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_embe2,		//NOSONAR
        /** <b>Caption:</b> grd_27_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_embe3,		//NOSONAR
        /** <b>Caption:</b> grd_27_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_embe4,		//NOSONAR
        /** <b>Caption:</b> grd_21_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_embi,		//NOSONAR
        /** <b>Caption:</b> grd_21_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_embi2,		//NOSONAR
        /** <b>Caption:</b> grd_21_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_embi3,		//NOSONAR
        /** <b>Caption:</b> grd_21_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_embi4,		//NOSONAR
        /** <b>Caption:</b> grd_20_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_embs,		//NOSONAR
        /** <b>Caption:</b> grd_20_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_embs2,		//NOSONAR
        /** <b>Caption:</b> grd_20_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_embs3,		//NOSONAR
        /** <b>Caption:</b> grd_20_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_embs4,		//NOSONAR
        /** <b>Caption:</b> grd_58_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_eprl,		//NOSONAR
        /** <b>Caption:</b> grd_58_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_eprl2,		//NOSONAR
        /** <b>Caption:</b> grd_58_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_eprl3,		//NOSONAR
        /** <b>Caption:</b> grd_58_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_eprl4,		//NOSONAR
        /** <b>Caption:</b> grd_33_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_esm,		//NOSONAR
        /** <b>Caption:</b> grd_33_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_esm2,		//NOSONAR
        /** <b>Caption:</b> grd_33_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_esm3,		//NOSONAR
        /** <b>Caption:</b> grd_33_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_esm4,		//NOSONAR
        /** <b>Caption:</b> 0#BasicaValores<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_fan,		//NOSONAR
        /** <b>Caption:</b> Columna 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_fan2,		//NOSONAR
        /** <b>Caption:</b> Columna 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_fan3,		//NOSONAR
        /** <b>Caption:</b> Columna 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_fan4,		//NOSONAR
        /** <b>Caption:</b> grd_26_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_flor,		//NOSONAR
        /** <b>Caption:</b> grd_26_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_flor2,		//NOSONAR
        /** <b>Caption:</b> grd_26_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_flor3,		//NOSONAR
        /** <b>Caption:</b> grd_26_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_flor4,		//NOSONAR
        /** <b>Caption:</b> 0#BasicaValores<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_gen,		//NOSONAR
        /** <b>Caption:</b> Columna 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_gen2,		//NOSONAR
        /** <b>Caption:</b> Columna 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_gen3,		//NOSONAR
        /** <b>Caption:</b> Columna 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_gen4,		//NOSONAR
        /** <b>Caption:</b> grd_56_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_goga,		//NOSONAR
        /** <b>Caption:</b> grd_56_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_goga2,		//NOSONAR
        /** <b>Caption:</b> grd_56_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_goga3,		//NOSONAR
        /** <b>Caption:</b> grd_56_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_goga4,		//NOSONAR
        /** <b>Caption:</b> grd_57_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_gogi,		//NOSONAR
        /** <b>Caption:</b> grd_57_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_gogi2,		//NOSONAR
        /** <b>Caption:</b> grd_57_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_gogi3,		//NOSONAR
        /** <b>Caption:</b> grd_57_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_gogi4,		//NOSONAR
        /** <b>Caption:</b> grd_44_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_gril,		//NOSONAR
        /** <b>Caption:</b> grd_44_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_gril2,		//NOSONAR
        /** <b>Caption:</b> grd_44_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_gril3,		//NOSONAR
        /** <b>Caption:</b> grd_44_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_gril4,		//NOSONAR
        /** <b>Caption:</b> grd_48_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_ioni,		//NOSONAR
        /** <b>Caption:</b> grd_48_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_ioni2,		//NOSONAR
        /** <b>Caption:</b> grd_48_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_ioni3,		//NOSONAR
        /** <b>Caption:</b> grd_48_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_ioni4,		//NOSONAR
        /** <b>Caption:</b> grd_38_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_iot,		//NOSONAR
        /** <b>Caption:</b> grd_38_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_iot2,		//NOSONAR
        /** <b>Caption:</b> grd_38_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_iot3,		//NOSONAR
        /** <b>Caption:</b> grd_38_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_iot4,		//NOSONAR
        /** <b>Caption:</b> grd_35_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_lamp,		//NOSONAR
        /** <b>Caption:</b> grd_35_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_lamp2,		//NOSONAR
        /** <b>Caption:</b> grd_35_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_lamp3,		//NOSONAR
        /** <b>Caption:</b> grd_35_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_lamp4,		//NOSONAR
        /** <b>Caption:</b> 0#BasicaValores<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_led,		//NOSONAR
        /** <b>Caption:</b> Columna 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_led2,		//NOSONAR
        /** <b>Caption:</b> Columna 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_led3,		//NOSONAR
        /** <b>Caption:</b> Columna 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_led4,		//NOSONAR
        /** <b>Caption:</b> 0#BasicaValores<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_ledmain,		//NOSONAR
        /** <b>Caption:</b> Columna 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_ledmain2,		//NOSONAR
        /** <b>Caption:</b> Columna 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_ledmain3,		//NOSONAR
        /** <b>Caption:</b> Columna 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_ledmain4,		//NOSONAR
        /** <b>Caption:</b> grd_31_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_lent,		//NOSONAR
        /** <b>Caption:</b> grd_31_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_lent2,		//NOSONAR
        /** <b>Caption:</b> grd_31_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_lent3,		//NOSONAR
        /** <b>Caption:</b> grd_31_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_lent4,		//NOSONAR
        /** <b>Caption:</b> grd_link1_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link11,		//NOSONAR
        /** <b>Caption:</b> grd_link1_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link12,		//NOSONAR
        /** <b>Caption:</b> grd_link1_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link13,		//NOSONAR
        /** <b>Caption:</b> grd_link1_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link14,		//NOSONAR
        /** <b>Caption:</b> grd_link2_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link21,		//NOSONAR
        /** <b>Caption:</b> grd_link2_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link22,		//NOSONAR
        /** <b>Caption:</b> grd_link2_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link23,		//NOSONAR
        /** <b>Caption:</b> grd_link2_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link24,		//NOSONAR
        /** <b>Caption:</b> grd_link3_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link31,		//NOSONAR
        /** <b>Caption:</b> grd_link3_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link32,		//NOSONAR
        /** <b>Caption:</b> grd_link3_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link33,		//NOSONAR
        /** <b>Caption:</b> grd_link3_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link34,		//NOSONAR
        /** <b>Caption:</b> grd_link4_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link41,		//NOSONAR
        /** <b>Caption:</b> grd_link4_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link42,		//NOSONAR
        /** <b>Caption:</b> grd_link4_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link43,		//NOSONAR
        /** <b>Caption:</b> grd_link4_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link44,		//NOSONAR
        /** <b>Caption:</b> grd_link5_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link51,		//NOSONAR
        /** <b>Caption:</b> grd_link5_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link52,		//NOSONAR
        /** <b>Caption:</b> grd_link5_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link53,		//NOSONAR
        /** <b>Caption:</b> grd_link5_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link54,		//NOSONAR
        /** <b>Caption:</b> grd_link6_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link61,		//NOSONAR
        /** <b>Caption:</b> grd_link6_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link62,		//NOSONAR
        /** <b>Caption:</b> grd_link6_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link63,		//NOSONAR
        /** <b>Caption:</b> grd_link6_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link64,		//NOSONAR
        /** <b>Caption:</b> grd_link7_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link71,		//NOSONAR
        /** <b>Caption:</b> grd_link7_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link72,		//NOSONAR
        /** <b>Caption:</b> grd_link7_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link73,		//NOSONAR
        /** <b>Caption:</b> grd_link7_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_link74,		//NOSONAR
        /** <b>Caption:</b> grd_61_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_lprin,		//NOSONAR
        /** <b>Caption:</b> grd_61_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_lprin2,		//NOSONAR
        /** <b>Caption:</b> grd_61_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_lprin3,		//NOSONAR
        /** <b>Caption:</b> grd_61_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_lprin4,		//NOSONAR
        /** <b>Caption:</b> grd_63_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_lsec,		//NOSONAR
        /** <b>Caption:</b> grd_63_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_lsec2,		//NOSONAR
        /** <b>Caption:</b> grd_63_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_lsec3,		//NOSONAR
        /** <b>Caption:</b> grd_63_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_lsec4,		//NOSONAR
        /** <b>Caption:</b> 0#BasicaValores<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_pack,		//NOSONAR
        /** <b>Caption:</b> Columna 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_pack2,		//NOSONAR
        /** <b>Caption:</b> Columna 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_pack3,		//NOSONAR
        /** <b>Caption:</b> Columna 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_pack4,		//NOSONAR
        /** <b>Caption:</b> grd_17_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_pala,		//NOSONAR
        /** <b>Caption:</b> grd_17_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_pala2,		//NOSONAR
        /** <b>Caption:</b> grd_17_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_pala3,		//NOSONAR
        /** <b>Caption:</b> grd_17_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_pala4,		//NOSONAR
        /** <b>Caption:</b> grd_45_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_part,		//NOSONAR
        /** <b>Caption:</b> grd_45_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_part2,		//NOSONAR
        /** <b>Caption:</b> grd_45_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_part3,		//NOSONAR
        /** <b>Caption:</b> grd_45_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_part4,		//NOSONAR
        /** <b>Caption:</b> grd_18_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_plat,		//NOSONAR
        /** <b>Caption:</b> grd_18_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_plat2,		//NOSONAR
        /** <b>Caption:</b> grd_18_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_plat3,		//NOSONAR
        /** <b>Caption:</b> grd_18_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_plat4,		//NOSONAR
        /** <b>Caption:</b> 0#BasicaValores<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_prod_inf,		//NOSONAR
        /** <b>Caption:</b> Columna 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_prod_inf2,		//NOSONAR
        /** <b>Caption:</b> Columna 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_prod_inf3,		//NOSONAR
        /** <b>Caption:</b> Columna 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_prod_inf4,		//NOSONAR
        /** <b>Caption:</b> grd_47_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_raxi,		//NOSONAR
        /** <b>Caption:</b> grd_47_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_raxi2,		//NOSONAR
        /** <b>Caption:</b> grd_47_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_raxi3,		//NOSONAR
        /** <b>Caption:</b> grd_47_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_raxi4,		//NOSONAR
        /** <b>Caption:</b> grd_30_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_refl,		//NOSONAR
        /** <b>Caption:</b> grd_30_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_refl2,		//NOSONAR
        /** <b>Caption:</b> grd_30_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_refl3,		//NOSONAR
        /** <b>Caption:</b> grd_30_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_refl4,		//NOSONAR
        /** <b>Caption:</b> 0#BasicaValores<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_remote,		//NOSONAR
        /** <b>Caption:</b> Columna 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_remote2,		//NOSONAR
        /** <b>Caption:</b> Columna 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_remote3,		//NOSONAR
        /** <b>Caption:</b> Columna 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_remote4,		//NOSONAR
        /** <b>Caption:</b> grd_39_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_sens,		//NOSONAR
        /** <b>Caption:</b> grd_39_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_sens2,		//NOSONAR
        /** <b>Caption:</b> grd_39_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_sens3,		//NOSONAR
        /** <b>Caption:</b> grd_39_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_sens4,		//NOSONAR
        /** <b>Caption:</b> grd_41_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_spe,		//NOSONAR
        /** <b>Caption:</b> grd_41_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_spe2,		//NOSONAR
        /** <b>Caption:</b> grd_41_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_spe3,		//NOSONAR
        /** <b>Caption:</b> grd_41_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_spe4,		//NOSONAR
        /** <b>Caption:</b> grd_42_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_spr,		//NOSONAR
        /** <b>Caption:</b> grd_42_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_spr2,		//NOSONAR
        /** <b>Caption:</b> grd_42_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_spr3,		//NOSONAR
        /** <b>Caption:</b> grd_42_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_spr4,		//NOSONAR
        /** <b>Caption:</b> grdtcomp_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tcomp,		//NOSONAR
        /** <b>Caption:</b> grdtcomp_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tcomp2,		//NOSONAR
        /** <b>Caption:</b> grdtcomp_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tcomp3,		//NOSONAR
        /** <b>Caption:</b> grdtcomp_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tcomp4,		//NOSONAR
        /** <b>Caption:</b> grd_59_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tdes,		//NOSONAR
        /** <b>Caption:</b> grd_59_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tdes2,		//NOSONAR
        /** <b>Caption:</b> grd_59_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tdes3,		//NOSONAR
        /** <b>Caption:</b> grd_59_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tdes4,		//NOSONAR
        /** <b>Caption:</b> 0#BasicaValores<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_test,		//NOSONAR
        /** <b>Caption:</b> Columna 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_test2,		//NOSONAR
        /** <b>Caption:</b> Columna 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_test3,		//NOSONAR
        /** <b>Caption:</b> Columna 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_test4,		//NOSONAR
        /** <b>Caption:</b> grd_22_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tibo,		//NOSONAR
        /** <b>Caption:</b> grd_22_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tibo2,		//NOSONAR
        /** <b>Caption:</b> grd_22_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tibo3,		//NOSONAR
        /** <b>Caption:</b> grd_22_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tibo4,		//NOSONAR
        /** <b>Caption:</b> grd_23_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tija,		//NOSONAR
        /** <b>Caption:</b> grd_23_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tija2,		//NOSONAR
        /** <b>Caption:</b> grd_23_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tija3,		//NOSONAR
        /** <b>Caption:</b> grd_23_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tija4,		//NOSONAR
        /** <b>Caption:</b> grd_24_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tuli,		//NOSONAR
        /** <b>Caption:</b> grd_24_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tuli2,		//NOSONAR
        /** <b>Caption:</b> grd_24_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tuli3,		//NOSONAR
        /** <b>Caption:</b> grd_24_1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalormaestro_tuli4,		//NOSONAR
        /** <b>Caption:</b> boolean 1<br>
        * <b>View Type:</b> FMView.VIEW_CHKSIMP<br> */
        txtvalorpasa1,		//NOSONAR
        /** <b>Caption:</b> Texto 1<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalortexto1,		//NOSONAR
        /** <b>Caption:</b> Texto 10<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalortexto10,		//NOSONAR
        /** <b>Caption:</b> Texto 2<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalortexto2,		//NOSONAR
        /** <b>Caption:</b> Texto 3<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalortexto3,		//NOSONAR
        /** <b>Caption:</b> Texto 4<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalortexto4,		//NOSONAR
        /** <b>Caption:</b> Texto 5<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalortexto5,		//NOSONAR
        /** <b>Caption:</b> Texto 6<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalortexto6,		//NOSONAR
        /** <b>Caption:</b> Texto 7<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalortexto7,		//NOSONAR
        /** <b>Caption:</b> Texto 8<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalortexto8,		//NOSONAR
        /** <b>Caption:</b> Texto 9<br>
        * <b>View Type:</b> FMView.VIEW_TEXTBOX<br> */
        txtvalortexto9		//NOSONAR
    }

    public enum SEGMENTS {
        /** <b>Description:</b> Grupos por artículo<br>
        * <b>Base query:</b> adv_articulo_grupo<br> */
        adv_articulo_grupo,		//NOSONAR
        /** <b>Description:</b> Padres del repuesto<br>
        * <b>Base query:</b> adv_padre_repuesto<br> */
        adv_padre_repuesto,		//NOSONAR
        /** <b>Description:</b> Componentes<br>
        * <b>Base query:</b> adv_repuesto_art<br> */
        adv_repuestos_art,		//NOSONAR
        /** <b>Description:</b> Opcionales<br>
        * <b>Base query:</b> pl_articulos_opc<br> */
        pl_articulo_opc,		//NOSONAR
        pnl_apart_alei,		//NOSONAR
        pnl_apart_alex,		//NOSONAR
        pnl_apart_appa,		//NOSONAR
        pnl_apart_appi,		//NOSONAR
        pnl_apart_aql,		//NOSONAR
        pnl_apart_aro,		//NOSONAR
        pnl_apart_asse,		//NOSONAR
        pnl_apart_base,		//NOSONAR
        pnl_apart_bate,		//NOSONAR
        pnl_apart_blad,		//NOSONAR
        pnl_apart_brac,		//NOSONAR
        pnl_apart_cabl,		//NOSONAR
        pnl_apart_came,		//NOSONAR
        pnl_apart_ccar,		//NOSONAR
        pnl_apart_ceil,		//NOSONAR
        pnl_apart_certif,		//NOSONAR
        pnl_apart_componentes,		//NOSONAR
        pnl_apart_control,		//NOSONAR
        pnl_apart_dat_chec,		//NOSONAR
        pnl_apart_dif,		//NOSONAR
        pnl_apart_dimension,		//NOSONAR
        pnl_apart_driver,		//NOSONAR
        pnl_apart_eim,		//NOSONAR
        pnl_apart_embe,		//NOSONAR
        pnl_apart_embi,		//NOSONAR
        pnl_apart_embs,		//NOSONAR
        pnl_apart_eprl,		//NOSONAR
        pnl_apart_esm,		//NOSONAR
        pnl_apart_fan,		//NOSONAR
        pnl_apart_flor,		//NOSONAR
        pnl_apart_general,		//NOSONAR
        pnl_apart_goga,		//NOSONAR
        pnl_apart_gogi,		//NOSONAR
        pnl_apart_gril,		//NOSONAR
        pnl_apart_ioni,		//NOSONAR
        pnl_apart_iot,		//NOSONAR
        pnl_apart_lamp,		//NOSONAR
        pnl_apart_led,		//NOSONAR
        pnl_apart_ledmain,		//NOSONAR
        pnl_apart_lent,		//NOSONAR
        pnl_apart_lprin,		//NOSONAR
        pnl_apart_lsec,		//NOSONAR
        pnl_apart_pack,		//NOSONAR
        pnl_apart_pala,		//NOSONAR
        pnl_apart_part,		//NOSONAR
        pnl_apart_plat,		//NOSONAR
        pnl_apart_prod_inf,		//NOSONAR
        pnl_apart_raxi,		//NOSONAR
        pnl_apart_refl,		//NOSONAR
        pnl_apart_remote,		//NOSONAR
        pnl_apart_sens,		//NOSONAR
        pnl_apart_spe,		//NOSONAR
        pnl_apart_spr,		//NOSONAR
        pnl_apart_tcompo,		//NOSONAR
        pnl_apart_tdes,		//NOSONAR
        pnl_apart_tecdat,		//NOSONAR
        pnl_apart_test,		//NOSONAR
        pnl_apart_tibo,		//NOSONAR
        pnl_apart_tija,		//NOSONAR
        pnl_apart_tuli,		//NOSONAR
        /** <b>Base query:</b> pl_articulos<br> */
        pnl_art_general,		//NOSONAR
        pnl_borrar_datos,		//NOSONAR
        pnl_campos_calculados,		//NOSONAR
        /** <b>Base query:</b> s_canal_art_c<br> */
        pnl_canal,		//NOSONAR
        /** <b>Base query:</b> s_canal_art_l<br> */
        pnl_canal_l,		//NOSONAR
        pnl_carac_art_vista,		//NOSONAR
        /** <b>Base query:</b> s_art_carac<br> */
        pnl_caracteristicas,		//NOSONAR
        /** <b>Base query:</b> s_caracteristicas<br> */
        pnl_caracteristicas_nombr,		//NOSONAR
        /** <b>Base query:</b> s_costes_art_c<br> */
        pnl_costes_concepto,		//NOSONAR
        pnl_duplicar_valores,		//NOSONAR
        /** <b>Base query:</b> s_art_desglose<br> */
        pnl_escandallo,		//NOSONAR
        /** <b>Base query:</b> s_art_it<br> */
        pnl_it,		//NOSONAR
        pnl_link_1,		//NOSONAR
        pnl_link_2,		//NOSONAR
        pnl_link_3,		//NOSONAR
        pnl_link_4,		//NOSONAR
        pnl_link_5,		//NOSONAR
        pnl_link_6,		//NOSONAR
        pnl_link_7,		//NOSONAR
        pnl_link_8,		//NOSONAR
        pnl_link_9,		//NOSONAR
        /** <b>Description:</b> Article technical data<br>
        * <b>Base query:</b> pl_artecnicos<br> */
        pnl_pl_artec,		//NOSONAR
        /** <b>Description:</b> Prices by article<br>
        * <b>Base query:</b> pl_artprec<br> */
        pnl_pl_artprec,		//NOSONAR
        /** <b>Description:</b> Ongoing stock ledger accounts<br>
        * <b>Base query:</b> pl_ctas_art_invp<br> */
        pnl_pl_ctas_art_invp,		//NOSONAR
        /** <b>Description:</b> Item description by language<br>
        * <b>Base query:</b> pl_fr_article_lang<br> */
        pnl_pl_fr_article_lang,		//NOSONAR
        /** <b>Description:</b> Graphs<br> */
        pnl_pl_graf_fact,		//NOSONAR
        /** <b>Description:</b> Artículos cruzados<br>
        * <b>Base query:</b> s_articulo_cruzado<br> */
        s_articulo_cruzado,		//NOSONAR
        /** <b>Base query:</b> pl_articulos<br> */
        s_articulos,		//NOSONAR
        /** <b>Base query:</b> adv_tarifa_clas<br> */
        s_tarifas,		//NOSONAR
        /** <b>Base query:</b> s_tarifas_art<br> */
        s_tarifas_art,		//NOSONAR
        /** <b>Base query:</b> s_halbpro<br> */
        sul_compras		//NOSONAR
    }

    public enum ITEMS {
        /** <b>Description:</b> Cantidad de un artículo por palet.<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> acantidad_palet<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Cantidad palet<br> */
        atxtcantidad_palet,		//NOSONAR
        /** <b>Segment name:</b> pnl_borrar_datos<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        aux_estado,		//NOSONAR
        /** <b>Description:</b> Total Coste<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Total Coste<br> */
        aux_total_coste,		//NOSONAR
        /** <b>Description:</b> Descripcion<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Descripcion<br> */
        auxdescripcion,		//NOSONAR
        /** <b>Description:</b> EAN<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> EAN<br> */
        auxean13,		//NOSONAR
        /** <b>Description:</b> Code language<br>
        * <b>Segment name:</b> pnl_pl_fr_article_lang<br>
        * <b>Query field:</b> xcode_langage<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Code language<br> */
        cbocode_langage,		//NOSONAR
        /** <b>Description:</b> Type of alternative code<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xtip_codalter<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Alternative code type<br> */
        cbotip_codalter,		//NOSONAR
        /** <b>Description:</b> Source or action of the item in the production process<br>
        * <b>Segment name:</b> pnl_pl_artec<br>
        * <b>Query field:</b> xtipo_articulo<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Article type<br> */
        cbotipo_articulo,		//NOSONAR
        /** <b>Description:</b> Impact type in needs management<br>
        * <b>Segment name:</b> pnl_pl_artec<br>
        * <b>Query field:</b> xtipo_gestion<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Type administration<br> */
        cbotipo_gestion,		//NOSONAR
        /** <b>Description:</b> Reduction method<br>
        * <b>Segment name:</b> pnl_pl_artec<br>
        * <b>Query field:</b> xtipo_rebaje<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Reduction type<br> */
        cbotipo_rebaje,		//NOSONAR
        /** <b>Description:</b> Check no pasa<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Check no pasa<br> */
        checknopasa,		//NOSONAR
        /** <b>Description:</b> It affects the planning<br>
        * <b>Segment name:</b> pnl_pl_artec<br>
        * <b>Query field:</b> xafecta_pmp<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Affects plan<br> */
        chkafecta_pmp,		//NOSONAR
        /** <b>Description:</b> Indicator of if the language is the one that was used to define the article<br>
        * <b>Segment name:</b> pnl_pl_fr_article_lang<br>
        * <b>Query field:</b> xalta<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Create<br> */
        chkalta,		//NOSONAR
        /** <b>Description:</b> Job stock control<br>
        * <b>Segment name:</b> pnl_pl_artec<br>
        * <b>Query field:</b> xctrl_alm_obra<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Job warehouse<br> */
        chkctrl_alm_obra,		//NOSONAR
        /** <b>Description:</b> Sale by units of issue administration<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xgest_agrupacion<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Sale by units of issue<br> */
        chkgest_agrupacion,		//NOSONAR
        /** <b>Description:</b> Management of expiry date<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xgest_caducidad<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Management expiry date<br> */
        chkgest_caducidad,		//NOSONAR
        /** <b>Description:</b> Stock management<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xgest_exist<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Stock management<br> */
        chkgest_exist,		//NOSONAR
        /** <b>Description:</b> Batch management<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xgest_lotes<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Management of batches<br> */
        chkgest_lotes,		//NOSONAR
        /** <b>Description:</b> Baja lógica<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> d328_baja<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Baja Lógica<br> */
        d328_baja,		//NOSONAR
        /** <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> d328_categoria<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Categoria<br> */
        d328_categoria,		//NOSONAR
        /** <b>Description:</b> Descripción larga<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> d328_desc_larga<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Long Description<br> */
        d328_desc_larga,		//NOSONAR
        /** <b>Description:</b> Fotografia del articulo<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> d328_fotoart<br>
        * <b>Data Type:</b> DA.DA_DT_LONGBINARY<br>
        * <b>Input Label:</b> Fotografia<br> */
        d328_fotoart,		//NOSONAR
        /** <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> d328_ilumina<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Iluminación<br> */
        d328_ilumina,		//NOSONAR
        /** <b>Description:</b> Unidades de la ecotasa<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> d328_uni_eco<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Unidades<br> */
        d328_uni_eco,		//NOSONAR
        /** <b>Description:</b> Tipo de Ecotasa<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> d328cod_ecotasa<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Tipo de Ecotasa<br> */
        d328cod_ecotasa,		//NOSONAR
        /** <b>Segment name:</b> pnl_pl_artprec<br>
        * <b>Query field:</b> d328precio_eco<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Ecotasa<br> */
        d328precio_eco,		//NOSONAR
        /** <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br> */
        envagrupok,		//NOSONAR
        /** <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        envcontrolexist,		//NOSONAR
        /** <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br> */
        envesnuevo,		//NOSONAR
        /** <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br> */
        envfcaducok,		//NOSONAR
        /** <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_DATE<br> */
        envfechacaducidad,		//NOSONAR
        /** <b>Description:</b> Orientable<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_ang<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> Orientable<br> */
        fx_ang,		//NOSONAR
        /** <b>Description:</b> apertura<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_apert<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> apertura<br> */
        fx_apert,		//NOSONAR
        /** <b>Description:</b> Argumentación<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_arg<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Argumentación<br> */
        fx_arg,		//NOSONAR
        /** <b>Description:</b> Bombilla incluida<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_bombill<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Bombilla incluida<br> */
        fx_bombill,		//NOSONAR
        /** <b>Description:</b> Canal asociado<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_canal<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Canal asociado<br> */
        fx_canal,		//NOSONAR
        /** <b>Description:</b> Características<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_caract<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Características<br> */
        fx_caract,		//NOSONAR
        /** <b>Description:</b> Tipo de casquillo<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_casq<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Tipo de casquillo<br> */
        fx_casq,		//NOSONAR
        /** <b>Description:</b> Categoria anterior<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_categanterior1<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Categoria anterior<br> */
        fx_categanterior1,		//NOSONAR
        /** <b>Description:</b> Categoría energética<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_catenerg<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Categoría energética<br> */
        fx_catenerg,		//NOSONAR
        /** <b>Description:</b> Categoría web<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_catweb<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Categoría web<br> */
        fx_catweb,		//NOSONAR
        /** <b>Description:</b> Airflow<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_caudal<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Airflow<br> */
        fx_caudal,		//NOSONAR
        /** <b>Description:</b> Color<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_color<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Color<br> */
        fx_color,		//NOSONAR
        /** <b>Description:</b> Consumo en W/h<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_consum<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Consumo en W/h<br> */
        fx_consum,		//NOSONAR
        /** <b>Description:</b> medidas de corte<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_corte<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> medidas de corte<br> */
        fx_corte,		//NOSONAR
        /** <b>Description:</b> CRI<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_cri<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> CRI<br> */
        fx_cri,		//NOSONAR
        /** <b>Description:</b> Decibelios<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_decibelios<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> Decibelios<br> */
        fx_decibelios,		//NOSONAR
        /** <b>Description:</b> posibilidad de dimar<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_dim<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> posibilidad de dimar<br> */
        fx_dim,		//NOSONAR
        /** <b>Description:</b> Driver dimable<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_dridim<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Driver dimable<br> */
        fx_dridim,		//NOSONAR
        /** <b>Description:</b> mando o driver asociado<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_driver<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> mando o driver asociado<br> */
        fx_driver,		//NOSONAR
        /** <b>Description:</b> Entrada driver<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_entdriv<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Entrada driver<br> */
        fx_entdriv,		//NOSONAR
        /** <b>Description:</b> Estancia indicada<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_estanc<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Estancia indicada<br> */
        fx_estanc,		//NOSONAR
        /** <b>Description:</b> Etiqueta<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_etiqueta<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Etiqueta<br> */
        fx_etiqueta,		//NOSONAR
        /** <b>Description:</b> Familia anterior<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_familiaant1<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Familia anterior<br> */
        fx_familiaant1,		//NOSONAR
        /** <b>Description:</b> Factor competitivo Esp<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_fctorcomp<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> Factor competitivo Esp<br> */
        fx_fctorcomp,		//NOSONAR
        /** <b>Description:</b> factor de potencia<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_fctorpoten<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> factor de potencia<br> */
        fx_fctorpoten,		//NOSONAR
        /** <b>Description:</b> Factor producto<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_fctorpro<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> Factor producto<br> */
        fx_fctorpro,		//NOSONAR
        /** <b>Description:</b> Forma<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_forma<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Forma<br> */
        fx_forma,		//NOSONAR
        /** <b>Description:</b> Foto del driver<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_fotodriv<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Foto del driver<br> */
        fx_fotodriv,		//NOSONAR
        /** <b>Description:</b> tipo Iluminacion anterior<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_iluminanterior1<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> tipo Iluminacion anterior<br> */
        fx_iluminanterior1,		//NOSONAR
        /** <b>Description:</b> IP<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_ip<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> IP<br> */
        fx_ip,		//NOSONAR
        /** <b>Description:</b> Cantidad de lúmenes<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_lmn<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> Cantidad de lúmenes<br> */
        fx_lmn,		//NOSONAR
        /** <b>Description:</b> Material<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_mater<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Material<br> */
        fx_mater,		//NOSONAR
        /** <b>Description:</b> Marca del chip<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_mcchip<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Marca del chip<br> */
        fx_mcchip,		//NOSONAR
        /** <b>Description:</b> Marca del driver<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_mcdriv<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Marca del driver<br> */
        fx_mcdriv,		//NOSONAR
        /** <b>Description:</b> Número de portalámparas<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_nport<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> Número de portalámparas<br> */
        fx_nport,		//NOSONAR
        /** <b>Description:</b> Precio futuro<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_precfut<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Precio futuro<br> */
        fx_precfut,		//NOSONAR
        /** <b>Description:</b> protocolo dimerización<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_protodim<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> protocolo dimerización<br> */
        fx_protodim,		//NOSONAR
        /** <b>Description:</b> Peso cartón<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_psocart<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Peso cartón<br> */
        fx_psocart,		//NOSONAR
        /** <b>Description:</b> Peso plástico<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_psoplast<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Peso plástico<br> */
        fx_psoplast,		//NOSONAR
        /** <b>Description:</b> RPM<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_rpm<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> RPM<br> */
        fx_rpm,		//NOSONAR
        /** <b>Description:</b> Salida driver<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_saldriv<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Salida driver<br> */
        fx_saldriv,		//NOSONAR
        /** <b>Description:</b> Subcategoría Web<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_sbcatweb<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Subcategoría Web<br> */
        fx_sbcatweb,		//NOSONAR
        /** <b>Description:</b> Sobrestock<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_sobrestock<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Sobrestock<br> */
        fx_sobrestock,		//NOSONAR
        /** <b>Description:</b> Subfamilia anterior<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_subfamanterior1<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Subfamilia anterior<br> */
        fx_subfamanterior1,		//NOSONAR
        /** <b>Description:</b> Temperatura color<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_tcolor<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Temperatura color<br> */
        fx_tcolor,		//NOSONAR
        /** <b>Description:</b> Tipología chip<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_tpchip<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Tipología chip<br> */
        fx_tpchip,		//NOSONAR
        /** <b>Description:</b> tipo de artículo<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_tpoart<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> tipo de artículo<br> */
        fx_tpoart,		//NOSONAR
        /** <b>Description:</b> tipo luminaria<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_tpolum<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> tipo luminaria<br> */
        fx_tpolum,		//NOSONAR
        /** <b>Description:</b> Vatios que tiene<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_vat1<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> Vatios que tiene<br> */
        fx_vat1,		//NOSONAR
        /** <b>Description:</b> Vatios que consume<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_vat2<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> Vatios que consume<br> */
        fx_vat2,		//NOSONAR
        /** <b>Description:</b> potencia<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_vatios<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> potencia<br> */
        fx_vatios,		//NOSONAR
        /** <b>Description:</b> Vda bombilla (h)<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_vida<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> Vda bombilla (h)<br> */
        fx_vida,		//NOSONAR
        /** <b>Description:</b> Voltaje<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_volt<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Voltaje<br> */
        fx_volt,		//NOSONAR
        /** <b>Description:</b> PáginaWeb<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> fx_web<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> PáginaWeb<br> */
        fx_web,		//NOSONAR
        /** <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_LONGBINARY<br> */
        picmas_datos,		//NOSONAR
        /** <b>Description:</b> Código ecotasa Sulion<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> scod_ecotasa<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Código ecotasa Sulion<br> */
        scod_ecotasa,		//NOSONAR
        /** <b>Description:</b> Cantidad de ecotasas<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> snum_ectsa<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Cantidad de ecotasas<br> */
        snum_ectsa,		//NOSONAR
        /** <b>Description:</b> Serie (Familia)<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> sserie<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Code of Family<br> */
        sserie,		//NOSONAR
        /** <b>Description:</b> Tipo lote<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> stipo_lote<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Tipo lote<br> */
        stipo_lote,		//NOSONAR
        /** <b>Description:</b> Aviso para almacen<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> saviso_almacen<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Aviso para almacen<br> */
        stxtaviso_almacen,		//NOSONAR
        /** <b>Description:</b> Aviso para compras<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> saviso_compras<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Aviso para compras<br> */
        stxtaviso_compras,		//NOSONAR
        /** <b>Description:</b> Aviso para ventas<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> saviso_ventas<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Aviso para ventas<br> */
        stxtaviso_ventas,		//NOSONAR
        /** <b>Description:</b> Canal preferente de Compra/Venta<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> scanal_pref<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Canal de Compra<br> */
        stxtcanal_pref,		//NOSONAR
        /** <b>Description:</b> Coste Desarrollo de producto<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> scos_desarrollo<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Coste Desarrollo de producto<br> */
        stxtcos_desarrollo,		//NOSONAR
        /** <b>Description:</b> Coste Devolucion<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> scos_devolucion<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Coste Devolucion<br> */
        stxtcos_devolucion,		//NOSONAR
        /** <b>Description:</b> Coste Transporte Compras<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> scos_flete<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Coste Transporte Compras<br> */
        stxtcos_flete,		//NOSONAR
        /** <b>Description:</b> Incoterm Costes<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> scos_incoterm<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Incoterm Costes<br> */
        stxtcos_incoterm,		//NOSONAR
        /** <b>Description:</b> Coste inspeccion de calidad<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> scos_inspcal<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Coste inspeccion de calidad<br> */
        stxtcos_inspcal,		//NOSONAR
        /** <b>Description:</b> Coste Seguro<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> scos_seguro<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Coste Seguro<br> */
        stxtcos_seguro,		//NOSONAR
        /** <b>Description:</b> % Depreciacion<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> sdepreciacion<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> % Depreciacion<br> */
        stxtdepreciacion,		//NOSONAR
        /** <b>Description:</b> Proveedor Interno<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> sprov_interno<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Proveedor Interno<br> */
        stxtprov_interno,		//NOSONAR
        /** <b>Description:</b> Situacion del articulo<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> ssituacion<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Situacion del articulo<br> */
        stxtsituacion,		//NOSONAR
        /** <b>Description:</b> Tipo Tarifa<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> stipotar_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Tipo Tarifa<br> */
        stxttipotar_id,		//NOSONAR
        /** <b>Description:</b> Prices grouper<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xagrupador_precio<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Price groupers by item<br> */
        txtagrupador_precio,		//NOSONAR
        /** <b>Description:</b> Warehouse<br>
        * <b>Segment name:</b> pnl_pl_ctas_art_invp<br>
        * <b>Query field:</b> xalmacen_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Code of Warehouse<br> */
        txtalmacen_id,		//NOSONAR
        /** <b>Description:</b> Item creation/modification indicator<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xalta_modif<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Amended<br> */
        txtalta_modif,		//NOSONAR
        /** <b>Description:</b> Item stock creation/modification indicator<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xalta_modif_exist<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Amended for stock<br> */
        txtalta_modif_exist,		//NOSONAR
        /** <b>Description:</b> Artículo cruzado<br>
        * <b>Segment name:</b> s_articulo_cruzado<br>
        * <b>Query field:</b> xart_cruzado<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Article code<br> */
        txtart_cruzado,		//NOSONAR
        /** <b>Description:</b> Code of the item<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xarticulo_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Code of the item<br> */
        txtarticulo_id,		//NOSONAR
        /** <b>Description:</b> Código de artículo de la caracteristica<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xarticulo_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Article code<br> */
        txtarticulo_id_c,		//NOSONAR
        /** <b>Description:</b> Código de artículo del canal<br>
        * <b>Segment name:</b> pnl_canal<br>
        * <b>Query field:</b> xarticulo_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Article code<br> */
        txtarticulo_id_can,		//NOSONAR
        /** <b>Segment name:</b> pnl_canal_l<br>
        * <b>Query field:</b> xarticulo_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Article code<br> */
        txtarticulo_id_canl,		//NOSONAR
        /** <b>Description:</b> Artículo costes concepto<br>
        * <b>Segment name:</b> pnl_costes_concepto<br>
        * <b>Query field:</b> xarticulo_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Article code<br> */
        txtarticulo_id_cc,		//NOSONAR
        /** <b>Description:</b> Artículo cruzado<br>
        * <b>Segment name:</b> s_articulo_cruzado<br>
        * <b>Query field:</b> xarticulo_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Article code<br> */
        txtarticulo_id_cruz,		//NOSONAR
        /** <b>Description:</b> Artículo escandallo<br>
        * <b>Segment name:</b> pnl_escandallo<br>
        * <b>Query field:</b> xarticulo_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Article code<br> */
        txtarticulo_id_des,		//NOSONAR
        /** <b>Description:</b> Código de artículo a duplicar<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Código de artículo a duplicar<br> */
        txtarticulo_id_duplica,		//NOSONAR
        /** <b>Description:</b> Artículo IT<br>
        * <b>Segment name:</b> pnl_it<br>
        * <b>Query field:</b> xarticulo_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Article code<br> */
        txtarticulo_id_it,		//NOSONAR
        /** <b>Description:</b> Código de artículo del padre<br>
        * <b>Segment name:</b> adv_padre_repuesto<br>
        * <b>Query field:</b> xarticulo_id_padre<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Article code<br> */
        txtarticulo_id_padre,		//NOSONAR
        /** <b>Description:</b> Artículo tarifas<br>
        * <b>Segment name:</b> s_tarifas_art<br>
        * <b>Query field:</b> xarticulo_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Article code<br> */
        txtarticulo_id_tart,		//NOSONAR
        /** <b>Description:</b> Obligatorio en Basica<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xbasicaobliga<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Basica<br> */
        txtbasicaobliga,		//NOSONAR
        /** <b>Description:</b> Campo de la tabla a filtrar<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xcampofiltrolista<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Campo<br> */
        txtcampofiltrolista,		//NOSONAR
        /** <b>Description:</b> Canal<br>
        * <b>Segment name:</b> pnl_canal<br>
        * <b>Query field:</b> xcanal_id<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Canal<br> */
        txtcanal_id_can,		//NOSONAR
        /** <b>Description:</b> Canal<br>
        * <b>Segment name:</b> pnl_canal_l<br>
        * <b>Query field:</b> xcanal_id<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Canal<br> */
        txtcanal_id_canl,		//NOSONAR
        /** <b>Description:</b> Canaltarifas<br>
        * <b>Segment name:</b> s_tarifas<br>
        * <b>Query field:</b> xcanal_id<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Canal<br> */
        txtcanal_id_tar,		//NOSONAR
        /** <b>Description:</b> Canal Venta<br>
        * <b>Segment name:</b> pnl_canal_l<br>
        * <b>Query field:</b> xcanal_vta<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Canal Venta<br> */
        txtcanal_vta_canl,		//NOSONAR
        /** <b>Description:</b> Cantidad de artículo que debe emitirse<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Cantidad<br> */
        txtcant_pedcli,		//NOSONAR
        /** <b>Description:</b> Cantidad de artículo que debe pedirse<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Cantidad<br> */
        txtcant_pedpro,		//NOSONAR
        /** <b>Description:</b> Cantidad costes concepto<br>
        * <b>Segment name:</b> pnl_costes_concepto<br>
        * <b>Query field:</b> xcantidad<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Cantidad<br> */
        txtcantidad_cc,		//NOSONAR
        /** <b>Description:</b> Cantidad escandallo<br>
        * <b>Segment name:</b> pnl_escandallo<br>
        * <b>Query field:</b> xcantidad<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Cantidad<br> */
        txtcantidad_des,		//NOSONAR
        /** <b>Description:</b> Quantity of the primary unit<br>
        * <b>Segment name:</b> sul_compras<br>
        * <b>Query field:</b> xcantidad_prin<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Primary quantity<br> */
        txtcantidad_prin_comp,		//NOSONAR
        /** <b>Description:</b> Total quantity sold<br>
        * <b>Segment name:</b> pnl_pl_graf_fact<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Total quantity<br> */
        txtcantidad_total,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_alei<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_alei,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_alex<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_alex,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_appa<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_appa,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_appi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_appi,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_aql<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_aql,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_aro<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_aro,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_asse<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_asse,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_base<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_base,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_bate<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_bate,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_blad<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_blad,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_brac<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_brac,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_cabl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_cabl,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_came<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_came,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ccar<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_ccar,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ceil<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_ceil,		//NOSONAR
        /** <b>Description:</b> Caracteristica certificado<br>
        * <b>Segment name:</b> pnl_apart_certif<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica<br> */
        txtcaracteristica_certif,		//NOSONAR
        /** <b>Description:</b> Caracteristica componentes<br>
        * <b>Segment name:</b> pnl_apart_componentes<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica<br> */
        txtcaracteristica_comp,		//NOSONAR
        /** <b>Description:</b> Caracteristica de control<br>
        * <b>Segment name:</b> pnl_apart_control<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica<br> */
        txtcaracteristica_control,		//NOSONAR
        /** <b>Description:</b> Caracteristica del check<br>
        * <b>Segment name:</b> pnl_apart_dat_chec<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica<br> */
        txtcaracteristica_dat_che,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_dif<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_dif,		//NOSONAR
        /** <b>Description:</b> Caracteristica de dimension<br>
        * <b>Segment name:</b> pnl_apart_dimension<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica<br> */
        txtcaracteristica_dimen,		//NOSONAR
        /** <b>Description:</b> Caracteristica driver<br>
        * <b>Segment name:</b> pnl_apart_driver<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica<br> */
        txtcaracteristica_driver,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_eim<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_eim,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embe<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_embe,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_embi,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embs<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_embs,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_eprl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_eprl,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_esm<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_esm,		//NOSONAR
        /** <b>Description:</b> Caracteristica fan<br>
        * <b>Segment name:</b> pnl_apart_fan<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica<br> */
        txtcaracteristica_fan,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_flor<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_flor,		//NOSONAR
        /** <b>Description:</b> Caracteristica general<br>
        * <b>Segment name:</b> pnl_apart_general<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica<br> */
        txtcaracteristica_gen,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_goga<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_goga,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_gogi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_gogi,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_gril<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_gril,		//NOSONAR
        /** <b>Description:</b> Caracteristica<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xcaracteristica_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica<br> */
        txtcaracteristica_id,		//NOSONAR
        /** <b>Description:</b> Caracteristica<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xcaracteristica_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica<br> */
        txtcaracteristica_id_c,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ioni<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_ioni,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_iot<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_iot,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lamp<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_lamp,		//NOSONAR
        /** <b>Description:</b> Caracteristica led<br>
        * <b>Segment name:</b> pnl_apart_led<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica<br> */
        txtcaracteristica_led,		//NOSONAR
        /** <b>Description:</b> Caracteristica ledmain<br>
        * <b>Segment name:</b> pnl_apart_ledmain<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica<br> */
        txtcaracteristica_ledmain,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lent<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_lent,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_1<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_link1,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_2<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_link2,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_3<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_link3,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_4<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_link4,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_5<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_link5,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_6<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_link6,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_7<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_link7,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_8<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_link8,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_9<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_link9,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lprin<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_lprin,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lsec<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_lsec,		//NOSONAR
        /** <b>Description:</b> Caracteristica pack<br>
        * <b>Segment name:</b> pnl_apart_pack<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica<br> */
        txtcaracteristica_pack,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_pala<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_pala,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_part<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_part,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_plat<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_plat,		//NOSONAR
        /** <b>Description:</b> Caracteristica prod_inf<br>
        * <b>Segment name:</b> pnl_apart_prod_inf<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica<br> */
        txtcaracteristica_prod_in,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_raxi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_raxi,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_refl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_refl,		//NOSONAR
        /** <b>Description:</b> Caracteristica remote<br>
        * <b>Segment name:</b> pnl_apart_remote<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica<br> */
        txtcaracteristica_remote,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_sens<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_sens,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_spe<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_spe,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_spr<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_spr,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tcompo<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_tcomp,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tdes<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_tdes,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tecdat<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_tecdat,		//NOSONAR
        /** <b>Description:</b> Caracteristica test<br>
        * <b>Segment name:</b> pnl_apart_test<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica<br> */
        txtcaracteristica_test,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tibo<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_tibo,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tija<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_tija,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tuli<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtcaracteristica_tuli,		//NOSONAR
        /** <b>Description:</b> Cycle to show in the graph<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Cycle<br> */
        txtciclo,		//NOSONAR
        /** <b>Description:</b> Cliente al que se realiza el pedido.<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Cliente<br> */
        txtcli_pedcli,		//NOSONAR
        /** <b>Description:</b> Cliente tarifas<br>
        * <b>Segment name:</b> s_tarifas<br>
        * <b>Query field:</b> xcliente_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Customer code<br> */
        txtcliente_id_tar,		//NOSONAR
        /** <b>Description:</b> Image code associated to this record<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xcod_bmp<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Image<br> */
        txtcod_bmp,		//NOSONAR
        /** <b>Description:</b> Tariff printing code<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xcodeedition_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Tariff print code<br> */
        txtcodeedition_id,		//NOSONAR
        /** <b>Description:</b> Article statistical code<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xcodestad_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Statistical code<br> */
        txtcodestad_id,		//NOSONAR
        /** <b>Description:</b> Columna 1 estado<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Columna 1<br> */
        txtcolumnaestado1,		//NOSONAR
        /** <b>Description:</b> Columna 2 estado<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Columna 2<br> */
        txtcolumnaestado2,		//NOSONAR
        /** <b>Description:</b> Columna 3 estado<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Columna 3<br> */
        txtcolumnaestado3,		//NOSONAR
        /** <b>Description:</b> Columna 4 estado<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Columna 4<br> */
        txtcolumnaestado4,		//NOSONAR
        /** <b>Description:</b> Comment code<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xcoment_albaran<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Delivery note comment<br> */
        txtcoment_albaran,		//NOSONAR
        /** <b>Description:</b> Comment code<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xcoment_factura<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Comment on invoice<br> */
        txtcoment_factura,		//NOSONAR
        /** <b>Description:</b> Comment code<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xcoment_hoja<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Comment picking list<br> */
        txtcoment_hoja,		//NOSONAR
        /** <b>Description:</b> Comment code<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xcoment_pedido<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Comment on order<br> */
        txtcoment_pedido,		//NOSONAR
        /** <b>Description:</b> Obligatorio en Comercial<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xcomercialobliga<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Comercial<br> */
        txtcomercialobliga,		//NOSONAR
        /** <b>Description:</b> ID of the item group to which the same commission is applied. You can only state this information if you selected the Item group for commissions option in the company parameters.<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xcomisart_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Code of Family<br> */
        txtcomisart_id,		//NOSONAR
        /** <b>Description:</b> Componente escandallo<br>
        * <b>Segment name:</b> pnl_escandallo<br>
        * <b>Query field:</b> xcomponente_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Article code<br> */
        txtcomponente_id_des,		//NOSONAR
        /** <b>Description:</b> ID concepto<br>
        * <b>Segment name:</b> pnl_costes_concepto<br>
        * <b>Query field:</b> xconcepto_id<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> ID<br> */
        txtconcepto_id_cc,		//NOSONAR
        /** <b>Description:</b> Coste IT<br>
        * <b>Segment name:</b> pnl_it<br>
        * <b>Query field:</b> xcoste<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Coste<br> */
        txtcoste,		//NOSONAR
        /** <b>Description:</b> Stock of products in progress<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xcta_encurso<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Being manufactured<br> */
        txtcta_encurso,		//NOSONAR
        /** <b>Description:</b> Stock of products in progress<br>
        * <b>Segment name:</b> pnl_pl_ctas_art_invp<br>
        * <b>Query field:</b> xcta_encurso<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Being manufactured<br> */
        txtcta_encurso_alm,		//NOSONAR
        /** <b>Description:</b> Stock variation of products in progress (Entries)<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xcta_encurso_ent<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Entries to manufacturing<br> */
        txtcta_encurso_ent,		//NOSONAR
        /** <b>Description:</b> Stock variation of products in progress (Entries)<br>
        * <b>Segment name:</b> pnl_pl_ctas_art_invp<br>
        * <b>Query field:</b> xcta_encurso_ent<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Entries to manufacturing<br> */
        txtcta_encurso_ent_alm,		//NOSONAR
        /** <b>Description:</b> Stock variation of products in progress (Withdrawals)<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xcta_encurso_sal<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Manufacturing withdrawals<br> */
        txtcta_encurso_sal,		//NOSONAR
        /** <b>Description:</b> Stock variation of products in progress (Withdrawals)<br>
        * <b>Segment name:</b> pnl_pl_ctas_art_invp<br>
        * <b>Query field:</b> xcta_encurso_sal<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Manufacturing withdrawals<br> */
        txtcta_encurso_sal_alm,		//NOSONAR
        /** <b>Description:</b> Stock<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xcta_exist<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Stock<br> */
        txtcta_exist,		//NOSONAR
        /** <b>Description:</b> Stock<br>
        * <b>Segment name:</b> pnl_pl_ctas_art_invp<br>
        * <b>Query field:</b> xcta_exist<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Accounting account<br> */
        txtcta_exist_alm,		//NOSONAR
        /** <b>Description:</b> Stock variation (Entries)<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xcta_exist_ent<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Entries to stock<br> */
        txtcta_exist_ent,		//NOSONAR
        /** <b>Description:</b> Stock variation (Entries)<br>
        * <b>Segment name:</b> pnl_pl_ctas_art_invp<br>
        * <b>Query field:</b> xcta_exist_ent<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Entries to stock<br> */
        txtcta_exist_ent_alm,		//NOSONAR
        /** <b>Description:</b> Stock variation (Withdrawals)<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xcta_exist_sal<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Stock withdrawals<br> */
        txtcta_exist_sal,		//NOSONAR
        /** <b>Description:</b> Stock variation (Withdrawals)<br>
        * <b>Segment name:</b> pnl_pl_ctas_art_invp<br>
        * <b>Query field:</b> xcta_exist_sal<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Stock withdrawals<br> */
        txtcta_exist_sal_alm,		//NOSONAR
        /** <b>Description:</b> Volumen<br>
        * <b>Segment name:</b> pl_articulo_opc<br>
        * <b>Query field:</b> xd328_volumen<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Volumen<br> */
        txtd328_volumen,		//NOSONAR
        /** <b>Description:</b> Description of the grouping<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xdesc_agrup<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Grouping description<br> */
        txtdesc_agrup,		//NOSONAR
        /** <b>Description:</b> Item description<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xdescripcion<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Item<br> */
        txtdescripcion,		//NOSONAR
        /** <b>Description:</b> Descripcion<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xdescripcion<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Descripcion<br> */
        txtdescripcion_carac,		//NOSONAR
        /** <b>Description:</b> Primary description of the article<br>
        * <b>Segment name:</b> pnl_pl_fr_article_lang<br>
        * <b>Query field:</b> xdesignation<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Description<br> */
        txtdesignation,		//NOSONAR
        /** <b>Description:</b> Detailed description of the item<br>
        * <b>Segment name:</b> pnl_pl_fr_article_lang<br>
        * <b>Query field:</b> xdesignation_mlig<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Description<br> */
        txtdesignation_mlig,		//NOSONAR
        /** <b>Description:</b> Article dimensions<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xdimension<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Dimension<br> */
        txtdimension,		//NOSONAR
        /** <b>Description:</b> Disponible escandallo<br>
        * <b>Segment name:</b> pnl_escandallo<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Disponible<br> */
        txtdisponible_des,		//NOSONAR
        /** <b>Description:</b> Divisa<br>
        * <b>Segment name:</b> pnl_campos_calculados<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Divisa<br> */
        txtdivisa,		//NOSONAR
        /** <b>Description:</b> Currency code<br>
        * <b>Segment name:</b> pnl_pl_artprec<br>
        * <b>Query field:</b> xdivisa_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Currency code<br> */
        txtdivisa_id,		//NOSONAR
        /** <b>Description:</b> Divisa tarifas<br>
        * <b>Segment name:</b> s_tarifas<br>
        * <b>Query field:</b> xdivisa_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Currency code<br> */
        txtdivisa_id_tar,		//NOSONAR
        /** <b>Description:</b> Divisa<br>
        * <b>Segment name:</b> s_tarifas_art<br>
        * <b>Query field:</b> xdivisa_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Currency code<br> */
        txtdivisa_id_tart,		//NOSONAR
        /** <b>Description:</b> Empresa cruzada<br>
        * <b>Segment name:</b> s_articulo_cruzado<br>
        * <b>Query field:</b> xempresa_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Active company code<br> */
        txtempresa_cruzada,		//NOSONAR
        /** <b>Description:</b> Company code<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xempresa_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Company code<br> */
        txtempresa_id,		//NOSONAR
        /** <b>Description:</b> Código de empresa<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xempresa_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Active company code<br> */
        txtempresa_id_c,		//NOSONAR
        /** <b>Description:</b> Empresa canal<br>
        * <b>Segment name:</b> pnl_canal<br>
        * <b>Query field:</b> xempresa_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Active company code<br> */
        txtempresa_id_can,		//NOSONAR
        /** <b>Segment name:</b> pnl_canal_l<br>
        * <b>Query field:</b> xempresa_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Active company code<br> */
        txtempresa_id_canl,		//NOSONAR
        /** <b>Description:</b> Empresa coste concepto<br>
        * <b>Segment name:</b> pnl_costes_concepto<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtempresa_id_cc,		//NOSONAR
        /** <b>Description:</b> Empresa escandallo<br>
        * <b>Segment name:</b> pnl_escandallo<br>
        * <b>Query field:</b> xempresa_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Active company code<br> */
        txtempresa_id_des,		//NOSONAR
        /** <b>Description:</b> Empresa IT<br>
        * <b>Segment name:</b> pnl_it<br>
        * <b>Query field:</b> xempresa_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Active company code<br> */
        txtempresa_id_it,		//NOSONAR
        /** <b>Description:</b> Empresa tarifas<br>
        * <b>Segment name:</b> s_tarifas_art<br>
        * <b>Query field:</b> xempresa_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Active company code<br> */
        txtempresa_id_tart,		//NOSONAR
        /** <b>Description:</b> Entidad<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Entidad<br> */
        txtentidad,		//NOSONAR
        /** <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtequivalente_id,		//NOSONAR
        /** <b>Description:</b> Caracteristicas especial<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xespecial<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Caracteristicas especial<br> */
        txtespecial,		//NOSONAR
        /** <b>Description:</b> Excluir de stock<br>
        * <b>Segment name:</b> pnl_escandallo<br>
        * <b>Query field:</b> xexcluir_stock<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Excluir de stock<br> */
        txtexcluir_stock,		//NOSONAR
        /** <b>Description:</b> Exist.Escandallo<br>
        * <b>Segment name:</b> pnl_escandallo<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Exist.<br> */
        txtexist_des,		//NOSONAR
        /** <b>Description:</b> Conversion coefficient between the measurement unit used in the project and the item main measurement unit<br>
        * <b>Segment name:</b> pnl_pl_artec<br>
        * <b>Query field:</b> xfactor<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Conversion factor<br> */
        txtfactor,		//NOSONAR
        /** <b>Description:</b> Calculation factor of number of packages<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xfactor_bultos<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Calculation factor of packages<br> */
        txtfactor_bultos,		//NOSONAR
        /** <b>Description:</b> Conversion coefficient<br>
        * <b>Segment name:</b> pnl_pl_artec<br>
        * <b>Query field:</b> xfactor_conv_estr<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Factor conversion<br> */
        txtfactor_conv_estr,		//NOSONAR
        /** <b>Description:</b> Conversion factor from primary unit to the supplementary unit<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xfactor_usupl<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Conv. factor suppl. unit<br> */
        txtfactor_usupl,		//NOSONAR
        /** <b>Description:</b> Group code<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xfamilia_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Family<br> */
        txtfamilia_id,		//NOSONAR
        /** <b>Description:</b> Familia DSP<br>
        * <b>Segment name:</b> pnl_art_general<br>
        * <b>Query field:</b> xfamilia_produc<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Familia DSP<br> */
        txtfamilia_produc,		//NOSONAR
        /** <b>Description:</b> Date standard price<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xfec_prec_estand<br>
        * <b>Data Type:</b> DA.DA_DT_DATE<br>
        * <b>Input Label:</b> Date standard price<br> */
        txtfec_prec_estand,		//NOSONAR
        /** <b>Description:</b> Fecha Modifica Calidad<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xfech_mod_calidad<br>
        * <b>Data Type:</b> DA.DA_DT_DATE<br>
        * <b>Input Label:</b> Fecha Modifica Calidad<br> */
        txtfech_mod_calidad,		//NOSONAR
        /** <b>Description:</b> Fecha modifica producto<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xfech_mod_producto<br>
        * <b>Data Type:</b> DA.DA_DT_DATE<br>
        * <b>Input Label:</b> Fecha modifica producto<br> */
        txtfech_mod_producto,		//NOSONAR
        /** <b>Description:</b> Delivery note date<br>
        * <b>Segment name:</b> sul_compras<br>
        * <b>Query field:</b> xfecha_albaran<br>
        * <b>Data Type:</b> DA.DA_DT_DATE<br>
        * <b>Input Label:</b> Date delivery note<br> */
        txtfecha_albaran_comp,		//NOSONAR
        /** <b>Description:</b> Article creation date<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xfecha_alta<br>
        * <b>Data Type:</b> DA.DA_DT_DATE<br>
        * <b>Input Label:</b> Creation date<br> */
        txtfecha_alta,		//NOSONAR
        /** <b>Description:</b> Expiration date<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_DATE<br>
        * <b>Input Label:</b> Expiry date<br> */
        txtfecha_caducidad,		//NOSONAR
        /** <b>Description:</b> Fecha desde<br>
        * <b>Segment name:</b> s_tarifas<br>
        * <b>Query field:</b> xfecha_desde<br>
        * <b>Data Type:</b> DA.DA_DT_DATE<br>
        * <b>Input Label:</b> Fecha desde<br> */
        txtfecha_desde_tar,		//NOSONAR
        /** <b>Description:</b> Fecha hasta<br>
        * <b>Segment name:</b> s_tarifas<br>
        * <b>Query field:</b> xfecha_hasta<br>
        * <b>Data Type:</b> DA.DA_DT_DATE<br>
        * <b>Input Label:</b> Fecha hasta<br> */
        txtfecha_hasta_tar,		//NOSONAR
        /** <b>Description:</b> Date file start<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xfecha_if<br>
        * <b>Data Type:</b> DA.DA_DT_DATE<br>
        * <b>Input Label:</b> Date file start<br> */
        txtfecha_if,		//NOSONAR
        /** <b>Description:</b> Fecha<br>
        * <b>Segment name:</b> s_tarifas_art<br>
        * <b>Query field:</b> xfecha<br>
        * <b>Data Type:</b> DA.DA_DT_DATE<br>
        * <b>Input Label:</b> Fecha<br> */
        txtfecha_tart,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_control<br>
        * <b>Data Type:</b> DA.DA_DT_LONGBINARY<br> */
        txtfoto_control,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_dimension<br>
        * <b>Data Type:</b> DA.DA_DT_LONGBINARY<br> */
        txtfoto_dimen,		//NOSONAR
        /** <b>Description:</b> Foto IT<br>
        * <b>Segment name:</b> pnl_it<br>
        * <b>Query field:</b> xfoto<br>
        * <b>Data Type:</b> DA.DA_DT_MEMO<br>
        * <b>Input Label:</b> Foto<br> */
        txtfoto_it,		//NOSONAR
        /** <b>Description:</b> Foto Info<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xfotoinfo<br>
        * <b>Data Type:</b> DA.DA_DT_LONGBINARY<br>
        * <b>Input Label:</b> Foto Info<br> */
        txtfotoinfo,		//NOSONAR
        /** <b>Description:</b> Group of characteristics<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xgrupo_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Group of characteristics<br> */
        txtgrupo_id,		//NOSONAR
        /** <b>Description:</b> Item group ID<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xgrupoart_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Code of Family<br> */
        txtgrupoart_id,		//NOSONAR
        /** <b>Description:</b> Grupo articulo tarifas<br>
        * <b>Segment name:</b> s_tarifas<br>
        * <b>Query field:</b> xgrupoart_id<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Grupo articulo<br> */
        txtgrupoart_id_tar,		//NOSONAR
        /** <b>Description:</b> Icon used in the POS<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xicono<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Icon<br> */
        txticono,		//NOSONAR
        /** <b>Description:</b> Importe del coste<br>
        * <b>Segment name:</b> pnl_costes_concepto<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Imp.Coste<br> */
        txtimporte_cc,		//NOSONAR
        /** <b>Description:</b> Importe<br>
        * <b>Segment name:</b> pnl_costes_concepto<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Imp.Linea<br> */
        txtimporte_lin_cc,		//NOSONAR
        /** <b>Description:</b> Incoterm<br>
        * <b>Segment name:</b> pnl_campos_calculados<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Incoterm<br> */
        txtincoterm,		//NOSONAR
        /** <b>Description:</b> Info<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xinfo<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Info<br> */
        txtinfo,		//NOSONAR
        /** <b>Description:</b> Informacion<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtinfo_c,		//NOSONAR
        /** <b>Description:</b> Obligatorio en Inspeccion<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xinspeccionobliga<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Inspeccion<br> */
        txtinspeccionobliga,		//NOSONAR
        /** <b>Description:</b> IT<br>
        * <b>Segment name:</b> pnl_it<br>
        * <b>Query field:</b> xit<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> IT<br> */
        txtit_it,		//NOSONAR
        /** <b>Description:</b> VAT code<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xiva_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Tax rate<br> */
        txtiva_id,		//NOSONAR
        /** <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xlista1<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br> */
        txtlista1,		//NOSONAR
        /** <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xlistav1<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br> */
        txtlistav1_carac,		//NOSONAR
        /** <b>Description:</b> Obligatorio en MassProduction<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xmassobliga<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> MassProduction<br> */
        txtmassobliga,		//NOSONAR
        /** <b>Description:</b> Month (cardinal number)<br>
        * <b>Segment name:</b> pnl_pl_graf_fact<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Month<br> */
        txtmes,		//NOSONAR
        /** <b>Description:</b> Month of the year<br>
        * <b>Segment name:</b> pnl_pl_graf_fact<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Month<br> */
        txtmes_text,		//NOSONAR
        /** <b>Description:</b> Product key for the CFDI<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xmex_clavecfdi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> CFDI product key<br> */
        txtmex_clavecfdi,		//NOSONAR
        /** <b>Description:</b> Modificado Calidad<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xmod_calidad<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Modificado Calidad<br> */
        txtmod_calidad,		//NOSONAR
        /** <b>Description:</b> Modificado Producto<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xmod_producto<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Modificado Producto<br> */
        txtmod_producto,		//NOSONAR
        /** <b>Description:</b> MQO<br>
        * <b>Segment name:</b> pnl_campos_calculados<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> MQO<br> */
        txtmqo,		//NOSONAR
        /** <b>Description:</b> Obligatorio en Muestra<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xmuestraobliga<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Muestra<br> */
        txtmuestraobliga,		//NOSONAR
        /** <b>Description:</b> Lowest level in the structures<br>
        * <b>Segment name:</b> pnl_pl_artec<br>
        * <b>Query field:</b> xnivel_estr<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Level structures<br> */
        txtnivel_estr,		//NOSONAR
        /** <b>Description:</b> Short name<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xnom_abreviado<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Abbreviation<br> */
        txtnom_abreviado,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ioni<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombre_ioni,		//NOSONAR
        /** <b>Description:</b> Nombre promoción tarifas<br>
        * <b>Segment name:</b> s_tarifas<br>
        * <b>Query field:</b> xnombre_promo<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombre promoción<br> */
        txtnombre_promo_tar,		//NOSONAR
        /** <b>Description:</b> Nombre1<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xnombre1<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombre1<br> */
        txtnombre1,		//NOSONAR
        /** <b>Description:</b> Nombre 10<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xnombre10<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombre 10<br> */
        txtnombre10,		//NOSONAR
        /** <b>Description:</b> Nombre2<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xnombre2<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombre2<br> */
        txtnombre2,		//NOSONAR
        /** <b>Description:</b> Nombre 3<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xnombre3<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombre 3<br> */
        txtnombre3,		//NOSONAR
        /** <b>Description:</b> Nombre 4<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xnombre4<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombre 4<br> */
        txtnombre4,		//NOSONAR
        /** <b>Description:</b> Nombre 5<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xnombre5<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombre 5<br> */
        txtnombre5,		//NOSONAR
        /** <b>Description:</b> Nombre 6<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xnombre6<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombre 6<br> */
        txtnombre6,		//NOSONAR
        /** <b>Description:</b> Nombre 7<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xnombre7<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombre 7<br> */
        txtnombre7,		//NOSONAR
        /** <b>Description:</b> Nombre 8<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xnombre8<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombre 8<br> */
        txtnombre8,		//NOSONAR
        /** <b>Description:</b> Nombre 9<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xnombre9<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombre 9<br> */
        txtnombre9,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_alei<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_alei,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_alex<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_alex,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_appa<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_appa,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_appi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_appi,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_aql<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_aql,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_aro<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_aro,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_asse<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_asse,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_base<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_base,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_bate<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_bate,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_blad<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_blad,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_brac<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_brac,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_cabl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_cabl,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_came<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_came,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ccar<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_ccar,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ceil<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_ceil,		//NOSONAR
        /** <b>Description:</b> Nombres certificado<br>
        * <b>Segment name:</b> pnl_apart_certif<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombres<br> */
        txtnombres_certif,		//NOSONAR
        /** <b>Description:</b> Nombres de los componentes<br>
        * <b>Segment name:</b> pnl_apart_componentes<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombres<br> */
        txtnombres_comp,		//NOSONAR
        /** <b>Description:</b> Nombres de control<br>
        * <b>Segment name:</b> pnl_apart_control<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombres<br> */
        txtnombres_control,		//NOSONAR
        /** <b>Description:</b> Nombres del check<br>
        * <b>Segment name:</b> pnl_apart_dat_chec<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombres<br> */
        txtnombres_dat_chec,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_dif<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_dif,		//NOSONAR
        /** <b>Description:</b> Nombres de dimension<br>
        * <b>Segment name:</b> pnl_apart_dimension<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombres<br> */
        txtnombres_dimen,		//NOSONAR
        /** <b>Description:</b> Nombres driver<br>
        * <b>Segment name:</b> pnl_apart_driver<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombres<br> */
        txtnombres_driver,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_eim<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_eim,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embe<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_embe,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_embi,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embs<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_embs,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_eprl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_eprl,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_esm<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_esm,		//NOSONAR
        /** <b>Description:</b> Nombres fan<br>
        * <b>Segment name:</b> pnl_apart_fan<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombres<br> */
        txtnombres_fan,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_flor<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_flor,		//NOSONAR
        /** <b>Description:</b> Nombres general<br>
        * <b>Segment name:</b> pnl_apart_general<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombres<br> */
        txtnombres_gen,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_goga<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_goga,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_gogi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_gogi,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_gril<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_gril,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_iot<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_iot,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lamp<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_lamp,		//NOSONAR
        /** <b>Description:</b> Nombres led<br>
        * <b>Segment name:</b> pnl_apart_led<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombres<br> */
        txtnombres_led,		//NOSONAR
        /** <b>Description:</b> Nombres ledmain<br>
        * <b>Segment name:</b> pnl_apart_ledmain<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombres<br> */
        txtnombres_ledmain,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lent<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_lent,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_1<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_link1,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_2<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_link2,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_3<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_link3,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_4<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_link4,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_5<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_link5,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_6<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_link6,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_7<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_link7,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_8<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_link8,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_9<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_link9,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lprin<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_lprin,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lsec<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_lsec,		//NOSONAR
        /** <b>Description:</b> Nombres pack<br>
        * <b>Segment name:</b> pnl_apart_pack<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombres<br> */
        txtnombres_pack,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_pala<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_pala,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_part<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_part,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_plat<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_plat,		//NOSONAR
        /** <b>Description:</b> Nombres prod_inf<br>
        * <b>Segment name:</b> pnl_apart_prod_inf<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombres<br> */
        txtnombres_prod_inf,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_raxi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_raxi,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_refl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_refl,		//NOSONAR
        /** <b>Description:</b> Nombres remote<br>
        * <b>Segment name:</b> pnl_apart_remote<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombres<br> */
        txtnombres_remote,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_sens<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_sens,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_spe<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_spe,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_spr<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_spr,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tcompo<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_tcomp,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tdes<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_tdes,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tecdat<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_tecdat,		//NOSONAR
        /** <b>Description:</b> Nombres test<br>
        * <b>Segment name:</b> pnl_apart_test<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Nombres<br> */
        txtnombres_test,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tibo<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_tibo,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tija<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_tija,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tuli<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtnombres_tuli,		//NOSONAR
        /** <b>Description:</b> Item combined nomenclature code<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xnomen_comb<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Combined nomenclature<br> */
        txtnomen_comb,		//NOSONAR
        /** <b>Description:</b> Indique el número de pedido únicamente si desea añadir la venta a un pedido existente<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> Pedido<br> */
        txtnum_pedcli,		//NOSONAR
        /** <b>Description:</b> Indique el número de pedido únicamente si desea añadir la compra a un pedido existente<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> Pedido<br> */
        txtnum_pedpro,		//NOSONAR
        /** <b>Segment name:</b> s_tarifas_art<br>
        * <b>Query field:</b> xnum_tarifa<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Nº Tarifa<br> */
        txtnum_tarifa_tart,		//NOSONAR
        /** <b>Description:</b> Last batch with characteristics used<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xnum_ult_lote<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> Last batch<br> */
        txtnum_ult_lote,		//NOSONAR
        /** <b>Description:</b> Number of the delivery note<br>
        * <b>Segment name:</b> sul_compras<br>
        * <b>Query field:</b> xnumdoc_id<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> Number<br> */
        txtnumdoc_id_comp,		//NOSONAR
        /** <b>Description:</b> Free text for article comments<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xobservaciones<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Comments<br> */
        txtobservaciones,		//NOSONAR
        /** <b>Description:</b> Comments on the delivery note<br>
        * <b>Segment name:</b> sul_compras<br>
        * <b>Query field:</b> xobservaciones<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Comments<br> */
        txtobservaciones_comp,		//NOSONAR
        /** <b>Description:</b> Repuesto opcional del padre<br>
        * <b>Segment name:</b> adv_padre_repuesto<br>
        * <b>Query field:</b> xopcional<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Opcional<br> */
        txtopcional_padre,		//NOSONAR
        /** <b>Description:</b> Largo<br>
        * <b>Segment name:</b> pl_articulo_opc<br>
        * <b>Query field:</b> xopcn1<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Largo<br> */
        txtopcn1,		//NOSONAR
        /** <b>Description:</b> Ancho<br>
        * <b>Segment name:</b> pl_articulo_opc<br>
        * <b>Query field:</b> xopcn2<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Ancho<br> */
        txtopcn2,		//NOSONAR
        /** <b>Description:</b> Alto<br>
        * <b>Segment name:</b> pl_articulo_opc<br>
        * <b>Query field:</b> xopcn3<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Alto<br> */
        txtopcn3,		//NOSONAR
        /** <b>Description:</b> Operador programacion<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xoperador<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Operador<br> */
        txtoperador,		//NOSONAR
        /** <b>Description:</b> Orden IT<br>
        * <b>Segment name:</b> pnl_it<br>
        * <b>Query field:</b> xorden<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Orden<br> */
        txtorden_it,		//NOSONAR
        /** <b>Description:</b> Code of the article customs entry<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xpart_arancel<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Customs entry<br> */
        txtpart_arancel,		//NOSONAR
        /** <b>Description:</b> Code of the stock type for the tax ledgers<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xper_tipo_exist<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Stock type<br> */
        txtper_tipo_exist,		//NOSONAR
        /** <b>Description:</b> Code of the collection of fuel tax, for CHL<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xpercepcion4_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Fuel tax<br> */
        txtpercepcion4_id,		//NOSONAR
        /** <b>Description:</b> Gross unit weight of article<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xpeso_bruto<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Gross weight<br> */
        txtpeso_bruto,		//NOSONAR
        /** <b>Description:</b> Net unit weight of article<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xpeso_neto<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Net weight<br> */
        txtpeso_neto,		//NOSONAR
        /** <b>Description:</b> % dto1<br>
        * <b>Segment name:</b> s_tarifas<br>
        * <b>Query field:</b> xpor_dto1<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> % dto1<br> */
        txtpor_dto1_tar,		//NOSONAR
        /** <b>Description:</b> % dto2<br>
        * <b>Segment name:</b> s_tarifas<br>
        * <b>Query field:</b> xpor_dto2<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> % dto2<br> */
        txtpor_dto2_tar,		//NOSONAR
        /** <b>Description:</b> Price by grouping<br>
        * <b>Segment name:</b> pnl_pl_artprec<br>
        * <b>Query field:</b> xprec_agrup<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Price by grouping<br> */
        txtprec_agrup,		//NOSONAR
        /** <b>Description:</b> Standard price<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xprec_estandar<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Standard price<br> */
        txtprec_estandar,		//NOSONAR
        /** <b>Description:</b> Average cost price<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xprec_med_coste<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Average cost price<br> */
        txtprec_med_coste,		//NOSONAR
        /** <b>Description:</b> Weighted Average Price<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> txtprec_med_pon<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Weighted Average Price<br> */
        txtprec_med_pon,		//NOSONAR
        /** <b>Description:</b> File start average price<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xprec_medio_if<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> File start average price<br> */
        txtprec_medio_if,		//NOSONAR
        /** <b>Description:</b> Price of the article with VAT included<br>
        * <b>Segment name:</b> pnl_pl_artprec<br>
        * <b>Query field:</b> xprec_ttc<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Price VAT incl.<br> */
        txtprec_ttc,		//NOSONAR
        /** <b>Description:</b> Last entry price<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xprec_ult_entra<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Last entry price<br> */
        txtprec_ult_entra,		//NOSONAR
        /** <b>Description:</b> Sales price<br>
        * <b>Segment name:</b> pnl_pl_artprec<br>
        * <b>Query field:</b> xprec_venta<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Sales price<br> */
        txtprec_venta,		//NOSONAR
        /** <b>Description:</b> Precio Neto<br>
        * <b>Segment name:</b> s_tarifas<br>
        * <b>Query field:</b> xprecio_neto<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Precio Neto<br> */
        txtprecio_neto_tar,		//NOSONAR
        /** <b>Description:</b> Precio tarifas<br>
        * <b>Segment name:</b> s_tarifas<br>
        * <b>Query field:</b> xprecio<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Precio<br> */
        txtprecio_tar,		//NOSONAR
        /** <b>Description:</b> Precio<br>
        * <b>Segment name:</b> s_tarifas_art<br>
        * <b>Query field:</b> xprecio<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Precio<br> */
        txtprecio_tart,		//NOSONAR
        /** <b>Description:</b> Proveedor al que se realiza el pedido<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Proveedor<br> */
        txtprov_pedpro,		//NOSONAR
        /** <b>Description:</b> Supplier code<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xproveedor_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Usual supplier<br> */
        txtproveedor_id,		//NOSONAR
        /** <b>Description:</b> Supplier code<br>
        * <b>Segment name:</b> pnl_art_general<br>
        * <b>Query field:</b> xproveedor_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Supplier code<br> */
        txtproveedor_id_gen,		//NOSONAR
        /** <b>Description:</b> Puerto<br>
        * <b>Segment name:</b> pnl_campos_calculados<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Puerto<br> */
        txtpuerto,		//NOSONAR
        /** <b>Description:</b> ID of the group of items where the same rebate is applied. You can only state this information if you selected the Item group for rebates option in the company parameters.<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xrappelart_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Code of Family<br> */
        txtrappelart_id,		//NOSONAR
        /** <b>Description:</b> Res.Hoja escandallo<br>
        * <b>Segment name:</b> pnl_escandallo<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Res.Hoja<br> */
        txtresehoja_des,		//NOSONAR
        /** <b>Description:</b> Res.Cliente escandallo<br>
        * <b>Segment name:</b> pnl_escandallo<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Res.Cliente<br> */
        txtresercli_des,		//NOSONAR
        /** <b>Description:</b> Section for which you want to know the sold item quantity.<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Section<br> */
        txtseccion_id,		//NOSONAR
        /** <b>Description:</b> Serie (Familia)<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> sserie<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Code of Family<br> */
        txtserie,		//NOSONAR
        /** <b>Description:</b> Situacion DSP<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xsituacion_dsp<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Situacion DSP<br> */
        txtsituacion_dsp,		//NOSONAR
        /** <b>Description:</b> Situación DSP<br>
        * <b>Segment name:</b> pnl_art_general<br>
        * <b>Query field:</b> xsituacion_dsp<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Situación DSP<br> */
        txtsituacion_dsp_gen,		//NOSONAR
        /** <b>Description:</b> Datos Destino<br>
        * <b>Segment name:</b> pnl_duplicar_valores<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Datos Destino<br> */
        txtsituaciondestino,		//NOSONAR
        /** <b>Description:</b> Datos Origen<br>
        * <b>Segment name:</b> pnl_duplicar_valores<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Datos Origen<br> */
        txtsituacionorigen,		//NOSONAR
        /** <b>Description:</b> Sub-group<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xssfamilia_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Subfamily<br> */
        txtssfamilia_id,		//NOSONAR
        /** <b>Description:</b> Volumen individual<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> svolumen<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Volumen<br> */
        txtsvolumen,		//NOSONAR
        /** <b>Description:</b> Article tariff<br>
        * <b>Segment name:</b> pnl_pl_artprec<br>
        * <b>Query field:</b> xtarifa_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Tariff<br> */
        txttarifa_id,		//NOSONAR
        /** <b>Description:</b> Item price list<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xtarifarticle<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Article tariff<br> */
        txttarifarticle,		//NOSONAR
        /** <b>Description:</b> Tecnología<br>
        * <b>Segment name:</b> pnl_art_general<br>
        * <b>Query field:</b> xtecnologia<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Tecnología<br> */
        txttecnologia,		//NOSONAR
        /** <b>Description:</b> Tipo de artículo<br>
        * <b>Segment name:</b> pnl_art_general<br>
        * <b>Query field:</b> xtipo_articulo<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Tipo de artículo<br> */
        txttipo_articulo,		//NOSONAR
        /** <b>Description:</b> Tipo<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Tipo<br> */
        txttipo_c,		//NOSONAR
        /** <b>Description:</b> Tipo de documento del pedido de ventas.<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Tipo de documento<br> */
        txttipodoc_pedcli,		//NOSONAR
        /** <b>Description:</b> Tipo de documento del pedido de compras.<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Tipo de documento<br> */
        txttipodoc_pedpro,		//NOSONAR
        /** <b>Description:</b> Code of the measurement unit used in the structures when it is different from the item main unit<br>
        * <b>Segment name:</b> pnl_pl_artec<br>
        * <b>Query field:</b> xunidad_estr_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Measurement unit<br> */
        txtunidad_estr_id,		//NOSONAR
        /** <b>Description:</b> Code of the measurement unit used in the projects when it is different from the item main unit<br>
        * <b>Segment name:</b> pnl_pl_artec<br>
        * <b>Query field:</b> xunidad_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Measurement unit<br> */
        txtunidad_id,		//NOSONAR
        /** <b>Description:</b> Primary unit<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xunidad_prin_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Unit<br> */
        txtunidad_prin_id,		//NOSONAR
        /** <b>Description:</b> Item second unit<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xunidad2_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Unit<br> */
        txtunidad2_id,		//NOSONAR
        /** <b>Description:</b> Units for grouping<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xunidades_agrup<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> Units for grouping<br> */
        txtunidades_agrup,		//NOSONAR
        /** <b>Description:</b> Usuario Modifica Calidad<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xusu_mod_calidad<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> User<br> */
        txtusu_mod_calidad,		//NOSONAR
        /** <b>Description:</b> Usuario Modifica Producto<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xusu_mod_producto<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> User<br> */
        txtusu_mod_producto,		//NOSONAR
        /** <b>Description:</b> User from karat that created the item<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xusuario_alta<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> User<br> */
        txtusuario_alta,		//NOSONAR
        /** <b>Description:</b> Usuario alta<br>
        * <b>Segment name:</b> s_tarifas_art<br>
        * <b>Query field:</b> xusuario<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> User<br> */
        txtusuario_tart,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_8<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalomaestro_link81,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_8<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalomaestro_link82,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_8<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalomaestro_link83,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_8<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalomaestro_link84,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_9<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalomaestro_link91,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_9<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalomaestro_link92,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_9<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalomaestro_link93,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_9<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalomaestro_link94,		//NOSONAR
        /** <b>Description:</b> Valor comercial<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalorcomercial<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Valor comercial<br> */
        txtvalorcomercial,		//NOSONAR
        /** <b>Description:</b> Decimal 1<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalordecimal1<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Decimal 1<br> */
        txtvalordecimal1,		//NOSONAR
        /** <b>Description:</b> Valor 1<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalordecimal1<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Valor 1<br> */
        txtvalordecimal1_carac,		//NOSONAR
        /** <b>Description:</b> Decimal 10<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalordecimal10<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Decimal 10<br> */
        txtvalordecimal10,		//NOSONAR
        /** <b>Description:</b> Decimal 2<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalordecimal2<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Decimal 2<br> */
        txtvalordecimal2,		//NOSONAR
        /** <b>Description:</b> Valor 2<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalordecimal2<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Valor 2<br> */
        txtvalordecimal2_carac,		//NOSONAR
        /** <b>Description:</b> Decimal 3<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalordecimal3<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Decimal 3<br> */
        txtvalordecimal3,		//NOSONAR
        /** <b>Description:</b> Valor 3<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalordecimal3<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Valor 3<br> */
        txtvalordecimal3_carac,		//NOSONAR
        /** <b>Description:</b> Decimal 4<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalordecimal4<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Decimal 4<br> */
        txtvalordecimal4,		//NOSONAR
        /** <b>Description:</b> Valor 4<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalordecimal4<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Valor 4<br> */
        txtvalordecimal4_carac,		//NOSONAR
        /** <b>Description:</b> Decimal 5<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalordecimal5<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Decimal 5<br> */
        txtvalordecimal5,		//NOSONAR
        /** <b>Description:</b> Valor 5<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalordecimal5<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Valor 5<br> */
        txtvalordecimal5_carac,		//NOSONAR
        /** <b>Description:</b> Decimal 6<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalordecimal6<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Decimal 6<br> */
        txtvalordecimal6,		//NOSONAR
        /** <b>Description:</b> Valor 6<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalordecimal6<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Valor 6<br> */
        txtvalordecimal6_carac,		//NOSONAR
        /** <b>Description:</b> Decimal 7<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalordecimal7<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Decimal 7<br> */
        txtvalordecimal7,		//NOSONAR
        /** <b>Description:</b> Decimal 8<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalordecimal8<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Decimal 8<br> */
        txtvalordecimal8,		//NOSONAR
        /** <b>Description:</b> Decimal 9<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalordecimal9<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Decimal 9<br> */
        txtvalordecimal9,		//NOSONAR
        /** <b>Description:</b> Valor Filtro listas (caracteristica/tabla)<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalorfiltro<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Valor Filtro<br> */
        txtvalorfiltro,		//NOSONAR
        /** <b>Description:</b> Numero 1<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalorint1<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Numero 1<br> */
        txtvalorint1,		//NOSONAR
        /** <b>Description:</b> Valor 1<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalorint1<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Valor 1<br> */
        txtvalorint1_carac,		//NOSONAR
        /** <b>Description:</b> Numero 10<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalorint10<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Numero 10<br> */
        txtvalorint10,		//NOSONAR
        /** <b>Description:</b> Numero 2<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalorint2<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Numero 2<br> */
        txtvalorint2,		//NOSONAR
        /** <b>Description:</b> Valor 2<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalorint2<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Valor 2<br> */
        txtvalorint2_carac,		//NOSONAR
        /** <b>Description:</b> Numero 3<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalorint3<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Numero 3<br> */
        txtvalorint3,		//NOSONAR
        /** <b>Description:</b> Valor 3<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalorint3<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Valor 3<br> */
        txtvalorint3_carac,		//NOSONAR
        /** <b>Description:</b> Numero 4<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalorint4<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Numero 4<br> */
        txtvalorint4,		//NOSONAR
        /** <b>Description:</b> Valor 4<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalorint4<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Valor 4<br> */
        txtvalorint4_carac,		//NOSONAR
        /** <b>Description:</b> Numero 5<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalorint5<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Numero 5<br> */
        txtvalorint5,		//NOSONAR
        /** <b>Description:</b> Valor 5<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalorint5<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Valor 5<br> */
        txtvalorint5_carac,		//NOSONAR
        /** <b>Description:</b> Numero 6<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalorint6<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Numero 6<br> */
        txtvalorint6,		//NOSONAR
        /** <b>Description:</b> Valor 6<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalorint6<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Valor 6<br> */
        txtvalorint6_carac,		//NOSONAR
        /** <b>Description:</b> Numero 7<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalorint7<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Numero 7<br> */
        txtvalorint7,		//NOSONAR
        /** <b>Description:</b> Numero 8<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalorint8<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Numero 8<br> */
        txtvalorint8,		//NOSONAR
        /** <b>Description:</b> Numero 9<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalorint9<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Numero 9<br> */
        txtvalorint9,		//NOSONAR
        /** <b>Description:</b> Lista<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalorlista1<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Lista<br> */
        txtvalorlista1,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_alei<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_alei,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_alei<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_alei2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_alei<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_alei3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_alei<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_alei4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_alex<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_alex,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_alex<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_alex2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_alex<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_alex3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_alex<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_alex4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_appa<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_appa,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_appa<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_appa2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_appa<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_appa3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_appa<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_appa4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_appi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_appi,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_appi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_appi2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_appi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_appi3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_appi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_appi4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_aql<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_aql,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_aql<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_aql2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_aql<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_aql3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_aql<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_aql4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_aro<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_aro,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_aro<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_aro2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_aro<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_aro3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_aro<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_aro4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_asse<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_asse,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_asse<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_asse2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_asse<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_asse3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_asse<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_asse4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_base<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_base,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_base<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_base2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_base<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_base3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_base<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_base4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_bate<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_bate,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_bate<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_bate2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_bate<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_bate3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_bate<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_bate4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_blad<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_blad,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_blad<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_blad2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_blad<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_blad3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_blad<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_blad4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_brac<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_brac,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_brac<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_brac2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_brac<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_brac3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_brac<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_brac4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_cabl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_cabl,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_cabl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_cabl2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_cabl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_cabl3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_cabl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_cabl4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_came<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_came,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_came<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_came2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_came<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_came3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_came<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_came4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ccar<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_ccar,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ccar<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_ccar2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ccar<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_ccar3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ccar<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_ccar4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ceil<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_ceil,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ceil<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_ceil2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ceil<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_ceil3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ceil<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_ceil4,		//NOSONAR
        /** <b>Description:</b> Valor maestro del certificado<br>
        * <b>Segment name:</b> pnl_apart_certif<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valores<br> */
        txtvalormaestro_certif,		//NOSONAR
        /** <b>Description:</b> Valor maestro del certificado 2<br>
        * <b>Segment name:</b> pnl_apart_certif<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 2<br> */
        txtvalormaestro_certif2,		//NOSONAR
        /** <b>Description:</b> Valor maestro del certificado 3<br>
        * <b>Segment name:</b> pnl_apart_certif<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 3<br> */
        txtvalormaestro_certif3,		//NOSONAR
        /** <b>Description:</b> Valor maestro del certificado 4<br>
        * <b>Segment name:</b> pnl_apart_certif<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 4<br> */
        txtvalormaestro_certif4,		//NOSONAR
        /** <b>Description:</b> Valor maestro de los componentes<br>
        * <b>Segment name:</b> pnl_apart_componentes<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valores<br> */
        txtvalormaestro_comp,		//NOSONAR
        /** <b>Description:</b> Valor maestro de los componentes 2<br>
        * <b>Segment name:</b> pnl_apart_componentes<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 2<br> */
        txtvalormaestro_comp2,		//NOSONAR
        /** <b>Description:</b> Valor maestro de los componentes 3<br>
        * <b>Segment name:</b> pnl_apart_componentes<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 3<br> */
        txtvalormaestro_comp3,		//NOSONAR
        /** <b>Description:</b> Valor maestro de los componentes 4<br>
        * <b>Segment name:</b> pnl_apart_componentes<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 4<br> */
        txtvalormaestro_comp4,		//NOSONAR
        /** <b>Description:</b> Valor maesto de control<br>
        * <b>Segment name:</b> pnl_apart_control<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> 0#Valores<br> */
        txtvalormaestro_control,		//NOSONAR
        /** <b>Description:</b> Valor maesto de control 2<br>
        * <b>Segment name:</b> pnl_apart_control<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 2<br> */
        txtvalormaestro_control2,		//NOSONAR
        /** <b>Description:</b> Valor maesto de control 3<br>
        * <b>Segment name:</b> pnl_apart_control<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 3<br> */
        txtvalormaestro_control3,		//NOSONAR
        /** <b>Description:</b> Valor maesto de control 4<br>
        * <b>Segment name:</b> pnl_apart_control<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 4<br> */
        txtvalormaestro_control4,		//NOSONAR
        /** <b>Description:</b> Valor maestro del check<br>
        * <b>Segment name:</b> pnl_apart_dat_chec<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valores<br> */
        txtvalormaestro_dat_chec,		//NOSONAR
        /** <b>Description:</b> Valor maestro del check 2<br>
        * <b>Segment name:</b> pnl_apart_dat_chec<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 2<br> */
        txtvalormaestro_dat_chec2,		//NOSONAR
        /** <b>Description:</b> Valor maestro del check 3<br>
        * <b>Segment name:</b> pnl_apart_dat_chec<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 3<br> */
        txtvalormaestro_dat_chec3,		//NOSONAR
        /** <b>Description:</b> Valor maestro del check 4<br>
        * <b>Segment name:</b> pnl_apart_dat_chec<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 4<br> */
        txtvalormaestro_dat_chec4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_dif<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_dif,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_dif<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_dif2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_dif<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_dif3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_dif<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_dif4,		//NOSONAR
        /** <b>Description:</b> Valor maestro de dimension<br>
        * <b>Segment name:</b> pnl_apart_dimension<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valores<br> */
        txtvalormaestro_dimen,		//NOSONAR
        /** <b>Description:</b> Valor maestro de dimension 2<br>
        * <b>Segment name:</b> pnl_apart_dimension<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 2<br> */
        txtvalormaestro_dimen2,		//NOSONAR
        /** <b>Description:</b> Valor maestro de dimension 3<br>
        * <b>Segment name:</b> pnl_apart_dimension<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 3<br> */
        txtvalormaestro_dimen3,		//NOSONAR
        /** <b>Description:</b> Valor maestro de dimension 4<br>
        * <b>Segment name:</b> pnl_apart_dimension<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 4<br> */
        txtvalormaestro_dimen4,		//NOSONAR
        /** <b>Description:</b> Valor maestro driver<br>
        * <b>Segment name:</b> pnl_apart_driver<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valores<br> */
        txtvalormaestro_driver,		//NOSONAR
        /** <b>Description:</b> Valor maestro driver 2<br>
        * <b>Segment name:</b> pnl_apart_driver<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 2<br> */
        txtvalormaestro_driver2,		//NOSONAR
        /** <b>Description:</b> Valor maestro driver 3<br>
        * <b>Segment name:</b> pnl_apart_driver<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 3<br> */
        txtvalormaestro_driver3,		//NOSONAR
        /** <b>Description:</b> Valor maestro driver 4<br>
        * <b>Segment name:</b> pnl_apart_driver<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 4<br> */
        txtvalormaestro_driver4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_eim<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_eim,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_eim<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_eim2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_eim<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_eim3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_eim<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_eim4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embe<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_embe,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embe<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_embe2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embe<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_embe3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embe<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_embe4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_embi,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_embi2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_embi3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_embi4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embs<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_embs,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embs<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_embs2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embs<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_embs3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_embs<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_embs4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_eprl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_eprl,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_eprl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_eprl2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_eprl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_eprl3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_eprl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_eprl4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_esm<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_esm,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_esm<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_esm2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_esm<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_esm3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_esm<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_esm4,		//NOSONAR
        /** <b>Description:</b> Valor maestro fan<br>
        * <b>Segment name:</b> pnl_apart_fan<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> 0#Valores<br> */
        txtvalormaestro_fan,		//NOSONAR
        /** <b>Description:</b> Valor maestro fan 2<br>
        * <b>Segment name:</b> pnl_apart_fan<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 2<br> */
        txtvalormaestro_fan2,		//NOSONAR
        /** <b>Description:</b> Valor maestro fan 3<br>
        * <b>Segment name:</b> pnl_apart_fan<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 3<br> */
        txtvalormaestro_fan3,		//NOSONAR
        /** <b>Description:</b> Valor maestro fan 4<br>
        * <b>Segment name:</b> pnl_apart_fan<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 4<br> */
        txtvalormaestro_fan4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_flor<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_flor,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_flor<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_flor2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_flor<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_flor3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_flor<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_flor4,		//NOSONAR
        /** <b>Description:</b> Valor maestro general<br>
        * <b>Segment name:</b> pnl_apart_general<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valores<br> */
        txtvalormaestro_gen,		//NOSONAR
        /** <b>Description:</b> Valor maestro general 2<br>
        * <b>Segment name:</b> pnl_apart_general<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 2<br> */
        txtvalormaestro_gen2,		//NOSONAR
        /** <b>Description:</b> Valor maestro general 3<br>
        * <b>Segment name:</b> pnl_apart_general<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 3<br> */
        txtvalormaestro_gen3,		//NOSONAR
        /** <b>Description:</b> Valor maestro general 4<br>
        * <b>Segment name:</b> pnl_apart_general<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 4<br> */
        txtvalormaestro_gen4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_goga<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_goga,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_goga<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_goga2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_goga<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_goga3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_goga<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_goga4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_gogi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_gogi,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_gogi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_gogi2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_gogi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_gogi3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_gogi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_gogi4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_gril<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_gril,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_gril<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_gril2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_gril<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_gril3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_gril<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_gril4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ioni<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_ioni,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ioni<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_ioni2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ioni<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_ioni3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_ioni<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_ioni4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_iot<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_iot,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_iot<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_iot2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_iot<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_iot3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_iot<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_iot4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lamp<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_lamp,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lamp<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_lamp2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lamp<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_lamp3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lamp<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_lamp4,		//NOSONAR
        /** <b>Description:</b> Valor maestro led<br>
        * <b>Segment name:</b> pnl_apart_led<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valores<br> */
        txtvalormaestro_led,		//NOSONAR
        /** <b>Description:</b> Valor maestro led 2<br>
        * <b>Segment name:</b> pnl_apart_led<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 2<br> */
        txtvalormaestro_led2,		//NOSONAR
        /** <b>Description:</b> Valor maestro led 3<br>
        * <b>Segment name:</b> pnl_apart_led<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 3<br> */
        txtvalormaestro_led3,		//NOSONAR
        /** <b>Description:</b> Valor maestro led 4<br>
        * <b>Segment name:</b> pnl_apart_led<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 4<br> */
        txtvalormaestro_led4,		//NOSONAR
        /** <b>Description:</b> Valor maestor ledmain<br>
        * <b>Segment name:</b> pnl_apart_ledmain<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valores<br> */
        txtvalormaestro_ledmain,		//NOSONAR
        /** <b>Description:</b> Valor maestor ledmain 2<br>
        * <b>Segment name:</b> pnl_apart_ledmain<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 2<br> */
        txtvalormaestro_ledmain2,		//NOSONAR
        /** <b>Description:</b> Valor maestor ledmain 3<br>
        * <b>Segment name:</b> pnl_apart_ledmain<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 3<br> */
        txtvalormaestro_ledmain3,		//NOSONAR
        /** <b>Description:</b> Valor maestor ledmain 4<br>
        * <b>Segment name:</b> pnl_apart_ledmain<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 4<br> */
        txtvalormaestro_ledmain4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lent<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_lent,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lent<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_lent2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lent<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_lent3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lent<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_lent4,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_1<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link11,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_1<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link12,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_1<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link13,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_1<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link14,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_2<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link21,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_2<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link22,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_2<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link23,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_2<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link24,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_3<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link31,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_3<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link32,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_3<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link33,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_3<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link34,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_4<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link41,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_4<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link42,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_4<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link43,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_4<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link44,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_5<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link51,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_5<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link52,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_5<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link53,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_5<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link54,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_6<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link61,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_6<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link62,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_6<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link63,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_6<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link64,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_7<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link71,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_7<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link72,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_7<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link73,		//NOSONAR
        /** <b>Segment name:</b> pnl_link_7<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_link74,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lprin<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_lprin,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lprin<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_lprin2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lprin<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_lprin3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lprin<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_lprin4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lsec<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_lsec,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lsec<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_lsec2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lsec<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_lsec3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_lsec<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_lsec4,		//NOSONAR
        /** <b>Description:</b> Valor maestro pack<br>
        * <b>Segment name:</b> pnl_apart_pack<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valores<br> */
        txtvalormaestro_pack,		//NOSONAR
        /** <b>Description:</b> Valor maestro pack 2<br>
        * <b>Segment name:</b> pnl_apart_pack<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 2<br> */
        txtvalormaestro_pack2,		//NOSONAR
        /** <b>Description:</b> Valor maestro pack 3<br>
        * <b>Segment name:</b> pnl_apart_pack<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 3<br> */
        txtvalormaestro_pack3,		//NOSONAR
        /** <b>Description:</b> Valor maestro pack 4<br>
        * <b>Segment name:</b> pnl_apart_pack<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 4<br> */
        txtvalormaestro_pack4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_pala<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_pala,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_pala<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_pala2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_pala<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_pala3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_pala<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_pala4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_part<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_part,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_part<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_part2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_part<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_part3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_part<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_part4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_plat<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_plat,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_plat<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_plat2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_plat<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_plat3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_plat<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_plat4,		//NOSONAR
        /** <b>Description:</b> Valor maestro prod_inf<br>
        * <b>Segment name:</b> pnl_apart_prod_inf<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valores<br> */
        txtvalormaestro_prod_inf,		//NOSONAR
        /** <b>Description:</b> Valor maestro prod_inf 2<br>
        * <b>Segment name:</b> pnl_apart_prod_inf<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 2<br> */
        txtvalormaestro_prod_inf2,		//NOSONAR
        /** <b>Description:</b> Valor maestro prod_inf 3<br>
        * <b>Segment name:</b> pnl_apart_prod_inf<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 3<br> */
        txtvalormaestro_prod_inf3,		//NOSONAR
        /** <b>Description:</b> Valor maestro prod_inf 4<br>
        * <b>Segment name:</b> pnl_apart_prod_inf<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 4<br> */
        txtvalormaestro_prod_inf4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_raxi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_raxi,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_raxi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_raxi2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_raxi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_raxi3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_raxi<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_raxi4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_refl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_refl,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_refl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_refl2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_refl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_refl3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_refl<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_refl4,		//NOSONAR
        /** <b>Description:</b> Valor maestro remote<br>
        * <b>Segment name:</b> pnl_apart_remote<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valores<br> */
        txtvalormaestro_remote,		//NOSONAR
        /** <b>Description:</b> Valor maestro remote 2<br>
        * <b>Segment name:</b> pnl_apart_remote<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 2<br> */
        txtvalormaestro_remote2,		//NOSONAR
        /** <b>Description:</b> Valor maestro remote 3<br>
        * <b>Segment name:</b> pnl_apart_remote<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 3<br> */
        txtvalormaestro_remote3,		//NOSONAR
        /** <b>Description:</b> Valor maestro remote 4<br>
        * <b>Segment name:</b> pnl_apart_remote<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 4<br> */
        txtvalormaestro_remote4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_sens<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_sens,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_sens<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_sens2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_sens<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_sens3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_sens<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_sens4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_spe<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_spe,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_spe<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_spe2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_spe<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_spe3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_spe<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_spe4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_spr<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_spr,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_spr<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_spr2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_spr<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_spr3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_spr<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_spr4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tcompo<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tcomp,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tcompo<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tcomp2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tcompo<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tcomp3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tcompo<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tcomp4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tdes<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tdes,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tdes<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tdes2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tdes<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tdes3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tdes<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tdes4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tecdat<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tecdat,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tecdat<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tecdat2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tecdat<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tecdat3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tecdat<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tecdat4,		//NOSONAR
        /** <b>Description:</b> Valor maestro test<br>
        * <b>Segment name:</b> pnl_apart_test<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valores<br> */
        txtvalormaestro_test,		//NOSONAR
        /** <b>Description:</b> Valor maestro test 2<br>
        * <b>Segment name:</b> pnl_apart_test<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 2<br> */
        txtvalormaestro_test2,		//NOSONAR
        /** <b>Description:</b> Valor maestro test 3<br>
        * <b>Segment name:</b> pnl_apart_test<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 3<br> */
        txtvalormaestro_test3,		//NOSONAR
        /** <b>Description:</b> Valor maestro test 4<br>
        * <b>Segment name:</b> pnl_apart_test<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Columna 4<br> */
        txtvalormaestro_test4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tibo<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tibo,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tibo<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tibo2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tibo<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tibo3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tibo<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tibo4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tija<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tija,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tija<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tija2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tija<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tija3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tija<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tija4,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tuli<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tuli,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tuli<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tuli2,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tuli<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tuli3,		//NOSONAR
        /** <b>Segment name:</b> pnl_apart_tuli<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        txtvalormaestro_tuli4,		//NOSONAR
        /** <b>Description:</b> Valor a mostrar<br>
        * <b>Segment name:</b> adv_articulo_grupo<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valor a mostrar<br> */
        txtvalormostrar,		//NOSONAR
        /** <b>Description:</b> boolean 1<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalorpasa1<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> boolean 1<br> */
        txtvalorpasa1,		//NOSONAR
        /** <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalorpasa1<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br> */
        txtvalorpasa1_carac,		//NOSONAR
        /** <b>Description:</b> Valor programacion 1<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalorprog1<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valor<br> */
        txtvalorprog1,		//NOSONAR
        /** <b>Description:</b> Valor programacion 2<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalorprog2<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valor<br> */
        txtvalorprog2,		//NOSONAR
        /** <b>Description:</b> Texto 1<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalortexto1<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Texto 1<br> */
        txtvalortexto1,		//NOSONAR
        /** <b>Description:</b> Valor 1<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalortexto1<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valor 1<br> */
        txtvalortexto1_carac,		//NOSONAR
        /** <b>Description:</b> Texto 10<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalortexto10<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Texto 10<br> */
        txtvalortexto10,		//NOSONAR
        /** <b>Description:</b> Texto 2<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalortexto2<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Texto 2<br> */
        txtvalortexto2,		//NOSONAR
        /** <b>Description:</b> Valor 2<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalortexto2<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valor 2<br> */
        txtvalortexto2_carac,		//NOSONAR
        /** <b>Description:</b> Texto 3<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalortexto3<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Texto 3<br> */
        txtvalortexto3,		//NOSONAR
        /** <b>Description:</b> Valor 3<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalortexto3<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Valor 3<br> */
        txtvalortexto3_carac,		//NOSONAR
        /** <b>Description:</b> Texto 4<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalortexto4<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Texto 4<br> */
        txtvalortexto4,		//NOSONAR
        /** <b>Description:</b> Valor 4<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalortexto4<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valor 4<br> */
        txtvalortexto4_carac,		//NOSONAR
        /** <b>Description:</b> Texto 5<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalortexto5<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Texto 5<br> */
        txtvalortexto5,		//NOSONAR
        /** <b>Description:</b> Valor 5<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalortexto5<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valor 5<br> */
        txtvalortexto5_carac,		//NOSONAR
        /** <b>Description:</b> Texto 6<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalortexto6<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Texto 6<br> */
        txtvalortexto6,		//NOSONAR
        /** <b>Description:</b> Valor 6<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalortexto6<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valor 6<br> */
        txtvalortexto6_carac,		//NOSONAR
        /** <b>Description:</b> Texto 7<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalortexto7<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Texto 7<br> */
        txtvalortexto7,		//NOSONAR
        /** <b>Description:</b> Texto 8<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalortexto8<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Texto 8<br> */
        txtvalortexto8,		//NOSONAR
        /** <b>Description:</b> Texto 9<br>
        * <b>Segment name:</b> pnl_caracteristicas<br>
        * <b>Query field:</b> xvalortexto9<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Texto 9<br> */
        txtvalortexto9,		//NOSONAR
        /** <b>Description:</b> Disponible como accesorio<br>
        * <b>Segment name:</b> adv_repuestos_art<br>
        * <b>Query field:</b> xaccesorio<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Disponible como accesorio<br> */
        xaccesorio,		//NOSONAR
        /** <b>Description:</b> Altura<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xaltura<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Altura (cm)<br> */
        xaltura,		//NOSONAR
        /** <b>Description:</b> Anchura<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xanchura<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Anchura (cm)<br> */
        xanchura,		//NOSONAR
        /** <b>Description:</b> Código de artículo de repuesto<br>
        * <b>Segment name:</b> adv_repuestos_art<br>
        * <b>Query field:</b> xarticulo_id<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Article code<br> */
        xarticulo_id,		//NOSONAR
        /** <b>Description:</b> Cantidad de repuesto<br>
        * <b>Segment name:</b> adv_repuestos_art<br>
        * <b>Query field:</b> xcantidad<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Cantidad<br> */
        xcantidad,		//NOSONAR
        /** <b>Description:</b> Caracteristica ID<br>
        * <b>Segment name:</b> pnl_carac_art_vista<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Caracteristica ID<br> */
        xcaracteristica_id_vista,		//NOSONAR
        /** <b>Description:</b> Grupo (Catálogo)<br>
        * <b>Segment name:</b> adv_articulo_grupo<br>
        * <b>Query field:</b> xgrupo_id<br>
        * <b>Data Type:</b> DA.DA_DT_BYTE<br>
        * <b>Input Label:</b> Grupo<br> */
        xgrupo_id,		//NOSONAR
        /** <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_LONGBINARY<br>
        * <b>Input Label:</b> Image<br> */
        ximagen_blo,		//NOSONAR
        /** <b>Description:</b> Más datos del articulo<br>
        * <b>Segment name:</b> pnl_pl_fr_article_lang<br>
        * <b>Query field:</b> xmasdatos<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Description<br> */
        xmasdatos,		//NOSONAR
        /** <b>Description:</b> Obsoleto<br>
        * <b>Segment name:</b> adv_repuestos_art<br>
        * <b>Query field:</b> xobsoleto<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Obsoleto<br> */
        xobsoleto,		//NOSONAR
        /** <b>Description:</b> Repuesto opcional<br>
        * <b>Segment name:</b> adv_repuestos_art<br>
        * <b>Query field:</b> xopcional<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Opcional<br> */
        xopcional,		//NOSONAR
        /** <b>Description:</b> Página<br>
        * <b>Segment name:</b> adv_articulo_grupo<br>
        * <b>Query field:</b> xpagina<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Página<br> */
        xpagina,		//NOSONAR
        /** <b>Description:</b> Tipo de bien o servicio sujeto a detracción<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xper_bien_id<br>
        * <b>Data Type:</b> DA.DA_DT_CHAR<br>
        * <b>Input Label:</b> Bien o servicio<br> */
        xper_bien_id,		//NOSONAR
        /** <b>Description:</b> Prestashop ID<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xpresta_id<br>
        * <b>Data Type:</b> DA.DA_DT_LONG<br>
        * <b>Input Label:</b> Prestashop ID<br> */
        xpresta_id,		//NOSONAR
        /** <b>Description:</b> Respuesto principal del producto a mostrar en la web, Catalogo,etc<br>
        * <b>Segment name:</b> adv_repuestos_art<br>
        * <b>Query field:</b> xprincipal<br>
        * <b>Data Type:</b> DA.DA_DT_BOOLEAN<br>
        * <b>Input Label:</b> Principal<br> */
        xprincipal,		//NOSONAR
        /** <b>Description:</b> Profundidad<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Query field:</b> xprofundidad<br>
        * <b>Data Type:</b> DA.DA_DT_CURRENCY<br>
        * <b>Input Label:</b> Profundidad (cm)<br> */
        xprofundidad,		//NOSONAR
        /** <b>Description:</b> Proveedor<br>
        * <b>Segment name:</b> adv_repuestos_art<br>
        * <b>Query field:</b> xproveedor<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Supplier code<br> */
        xproveedor,		//NOSONAR
        /** <b>Description:</b> Tipo filtro lista<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xtipofiltrolista<br>
        * <b>Data Type:</b> DA.DA_DT_INTEGER<br>
        * <b>Input Label:</b> Filtro<br> */
        xtipofiltrolista,		//NOSONAR
        /** <b>Description:</b> Tipo de movimiento del articulo que se desea crear.<br>
        * <b>Segment name:</b> s_articulos<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Tipo de movimiento<br> */
        xtipomov_crear,		//NOSONAR
        /** <b>Description:</b> Valor maestro<br>
        * <b>Segment name:</b> pnl_carac_art_vista<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br> */
        xvalormaestro,		//NOSONAR
        /** <b>Description:</b> Valor programacion 1<br>
        * <b>Segment name:</b> pnl_caracteristicas_nombr<br>
        * <b>Query field:</b> xvalorprog1<br>
        * <b>Data Type:</b> DA.DA_DT_TEXT<br>
        * <b>Input Label:</b> Valor<br> */
        xvalorprog1		//NOSONAR
    }

    

    

    

    

    

	

	

	

	public DAConnectionSource connSdic = null;
	public DAConnection connData = null;
	public DAResultSet oRes = null;
	public DAResultSet oRes2 = null;
	public DAResultSet oRes3 = null;
	public DAResultSet oResSimp = null;
	public DAResultSet oResSimp2 = null;

	public DAResultSet oResLink = null;
	public DAResultSet oResLink2 = null;
	public DAResultSet oResLink3 = null;

	public static String situacionColumna1 = "";
	public static String situacionColumna2 = "";
	public static String situacionColumna3 = "";
	public static String situacionColumna4 = "";
	public static String descripcion = "";

	public s_articulos(Session session) {
		super(session);
	}

	
	
	
	
	
	@Override
	public void formReadRecord(FMEvent fmEvent) throws OTException {
		// TODO Auto-generated method stub
		super.formReadRecord(fmEvent);
		fmEvent.setRecall(true);
		String sArticulo = getItem(ITEMS.txtarticulo_id).getValue();
		String sEmpresa = getItem(ITEMS.txtempresa_id).getValue();
		connSdic = session.getConnectionSource();
		connData = session.getConnectionData();
		String sEquivalente = getItem(ITEMS.txtequivalente_id).getValue();
		if(sEquivalente == null || sEquivalente.equals("")) {
			String sql="select equi.xarticulo_id,art.xdescripcion from imp.s_art_equivalentes equi"
					+ " inner join imp.pl_articulos art on art.xarticulo_id=equi.xarticulo_id and art.xempresa_id=equi.xempresa_id"
					+ " where equi.xequivalente_id='"+sArticulo+"' and equi.xempresa_id='"+sEmpresa+"' and art.xproducto_base=-1";
			oRes = connData.openSQL(sql);
			if(oRes.moveNext()) {
				sEquivalente = oRes.getString("xarticulo_id");
				String sDescripcion =oRes.getString("xdescripcion");

				getItem(ITEMS.txtequivalente_id).setValue(sEquivalente);
				sArticulo=sEquivalente;
				getView(VIEWS.lblmensaje).setValue("El producto que quiere analizar es equivalente, por lo tanto los cambios que realice serán sobre el articulo:\n"+sEquivalente+"-"+sDescripcion);
			}else {
				getItem(ITEMS.txtequivalente_id).setValue(sArticulo);
			}
			oRes.close();
		}else {
			sArticulo=sEquivalente;
		}
		
		rellenarCombosSituacion(sArticulo);

		String[] SituacionDatos1 = situacionColumna1.split("#");
		String[] SituacionDatos2 = situacionColumna2.split("#");
		String[] SituacionDatos3 = situacionColumna3.split("#");
		String[] SituacionDatos4 = situacionColumna4.split("#");
		String sSituacion1 = SituacionDatos1[0];
		String sSituacion2 = SituacionDatos2[0];
		String sSituacion3 = SituacionDatos3[0];
		String sSituacion4 = SituacionDatos4[0];

		if (!(sSituacion1 == null || sSituacion1.equals(""))) {
			rellenarRepuestosLink(sEmpresa, sArticulo, sSituacion1, 1);
		}
		if (!(sSituacion2 == null || sSituacion2.equals(""))) {
			rellenarRepuestosLink(sEmpresa, sArticulo, sSituacion2, 2);
		}
		if (!(sSituacion3 == null || sSituacion3.equals(""))) {
			rellenarRepuestosLink(sEmpresa, sArticulo, sSituacion3, 3);
		}
		if (!(sSituacion4 == null || sSituacion4.equals(""))) {
			rellenarRepuestosLink(sEmpresa, sArticulo, sSituacion4, 4);
		}
		if((!(sSituacion1 == null || sSituacion1.equals("")))|| (!(sSituacion2 == null || sSituacion2.equals("")))|| (!(sSituacion3 == null || sSituacion3.equals("")))|| (!(sSituacion4 == null || sSituacion4.equals("")))){
			rellenarPanelesSimplificado(sArticulo, sEmpresa);
		}
		ocultarVacios();
	}

	private void rellenarPaneles(String sArticulo, String sEmpresa) throws DAException {
		BOSegment iPanel = boObject.getSegment(SEGMENTS.pnl_apart_general);
		BOSegment iPanel2 = boObject.getSegment(SEGMENTS.pnl_apart_certif);
		BOSegment iPanel3 = boObject.getSegment(SEGMENTS.pnl_apart_pack);
		BOSegment iPanel4 = boObject.getSegment(SEGMENTS.pnl_apart_componentes);
		BOSegment iPanel5 = boObject.getSegment(SEGMENTS.pnl_apart_control);
		BOSegment iPanel6 = boObject.getSegment(SEGMENTS.pnl_apart_dimension);
		BOSegment iPanel7 = boObject.getSegment(SEGMENTS.pnl_apart_driver);
		BOSegment iPanel8 = boObject.getSegment(SEGMENTS.pnl_apart_fan);
		BOSegment iPanel9 = boObject.getSegment(SEGMENTS.pnl_apart_led);
		BOSegment iPanel10 = boObject.getSegment(SEGMENTS.pnl_apart_ledmain);
		BOSegment iPanel11 = boObject.getSegment(SEGMENTS.pnl_apart_prod_inf);
		BOSegment iPanel12 = boObject.getSegment(SEGMENTS.pnl_apart_remote);
		BOSegment iPanel13 = boObject.getSegment(SEGMENTS.pnl_apart_test);
		BOSegment iPanel14 = boObject.getSegment(SEGMENTS.pnl_apart_dat_chec);

		iPanel.setAllowInsert(true);
		iPanel2.setAllowInsert(true);
		iPanel3.setAllowInsert(true);
		iPanel4.setAllowInsert(true);
		iPanel5.setAllowInsert(true);
		iPanel6.setAllowInsert(true);
		iPanel7.setAllowInsert(true);
		iPanel8.setAllowInsert(true);
		iPanel9.setAllowInsert(true);
		iPanel10.setAllowInsert(true);
		iPanel11.setAllowInsert(true);
		iPanel12.setAllowInsert(true);
		iPanel13.setAllowInsert(true);
		iPanel14.setAllowInsert(true);

		iPanel.deleteRows();
		iPanel2.deleteRows();
		iPanel3.deleteRows();
		iPanel4.deleteRows();
		iPanel5.deleteRows();
		iPanel6.deleteRows();
		iPanel7.deleteRows();
		iPanel8.deleteRows();
		iPanel9.deleteRows();
		iPanel10.deleteRows();
		iPanel11.deleteRows();
		iPanel12.deleteRows();
		iPanel13.deleteRows();
		iPanel14.deleteRows();

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

		renombrarColumnas();
		// Sacamos los estados equivalentes a los check que tenga marcada la
		// caracteristica

		String sql = "select distinct est.xorden,carac.xdistinto, carac.xvalor,carac.xcaracteristica_f, est.xcaracteristica_id,estados from (select SUBSTRING(caract.xestados,0,len(caract.xestados)) as estados,* "
				+ " from (select *, " + " case car.xmuestra when -1 then cast('2,' as varchar)else '' end + "
				+ " case car.xbasica when -1 then cast('0,' as varchar) else '' end + "
				+ " case car.xcomercial when -1 then cast('8,' as varchar) else '' end + "
				+ " case car.xinspeccion when -1 then cast('4,' as varchar) else '' end+"
				+ " case xmassproduction when -1 then cast('6,' as varchar) else '' end as xestados from "
				+ connSdic.translateTable("s_caracteristicas") + " car) caract )est" + " inner join "
				+ connSdic.translateTable("s_carac_fam") + " fam on fam.xcaracteristica_id = est.xcaracteristica_id"
				+ " left outer join " + connSdic.translateTable("s_carac_carac")
				+ " carac on carac.xcaracteristica_id=est.xcaracteristica_id and fam.xempresa_id = carac.xempresa_id"
				+ " where xbaja=0 order by est.xorden";

		int i = 0;
		int iGeneral = 0;
		int iCertificados = 0;
		int iPack = 0;
		int iProductInf = 0;
		int iComponentes = 0;
		int iLed = 0;
		int iLedmain = 0;
		int iDriver = 0;
		int iControl = 0;
		int iFan = 0;
		int iDimension = 0;
		int iRemote = 0;
		int iTest = 0;
		int iDatosChequeo = 0;
		try (DAResultSet oRes3 = session.getConnectionData().openSQL(sql)) {
			while (oRes3.moveNext()) {
				String sCaracteristicaEstado = oRes3.getString("xcaracteristica_id");
				String sEstados = oRes3.getString("estados");
				String sCaracteristicaFiltro = oRes3.getString("xcaracteristica_f");
				String sValorFiltro = oRes3.getString("xvalor");
				String sDistinto = oRes3.getString("xdistinto");
				boolean pasaFiltro = false;
				if ((!(sCaracteristicaFiltro == null || sCaracteristicaFiltro.equals("")))
						&& (!(sValorFiltro == null || sValorFiltro.equals("")))) {
					if (sDistinto.equals("0")) {
						// Comprobamos si tienen algun filtro las caracteristicas.
						sql = "select xcaracteristica_id from " + connSdic.translateTable("s_art_carac")
								+ " where xarticulo_id ='" + sArticulo + "' and xcaracteristica_id='"
								+ sCaracteristicaFiltro + "' and xvalorlista1='" + sValorFiltro + "'";
						try (DAResultSet oRes = session.getConnectionData().openSQL(sql)) {
							if (oRes.moveNext()) {
								pasaFiltro = true;
							}
						} catch (OTException ot) {
							ot.printStackTrace();
							oRes.close();
							try {
								throw new PMException(session, ot);
							} catch (PMException e) {
								e.printStackTrace();
							}
						}
					} else {
						sql = "select xcaracteristica_id from " + connSdic.translateTable("s_art_carac")
								+ " where xarticulo_id ='" + sArticulo + "' and xcaracteristica_id='"
								+ sCaracteristicaFiltro + "' and xvalorlista1!='" + sValorFiltro + "'";
						try (DAResultSet oRes = session.getConnectionData().openSQL(sql)) {
							if (oRes.moveNext()) {
								pasaFiltro = true;
							}
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
				if (pasaFiltro == true) {
					if (!(sCaracteristicaEstado == null || sCaracteristicaEstado.equals(""))) {
						if (!(sEstados == null || sEstados.equals(""))) {
							int iIdioma = session.getLanguageCode();
							// Rellenamos los datos de los grid, tenemos 4 union, solo si tiene situaciones
							// de la dsp creadas, en función de la cantidad de caracteristicas que tenga se
							// rellenan de 1 a 4 columnas.

							sql = "select carm.xdescripcion,carm.xnombre1, carm.xnombre2,art.xsituacion_dsp situacionArt,gen.xfamilia_produc,gen.xtecnologia"
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
									+ " ELSE ' / ' + cast(art.xvalortexto6 as varchar) END "
									+ "CASE WHEN cast(art.xvalortexto7 as varchar)IS NULL OR cast(art.xvalortexto7 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalortexto7 as varchar) END "
									+ "CASE WHEN cast(art.xvalortexto8 as varchar)IS NULL OR cast(art.xvalortexto8 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalortexto8 as varchar) END "
									+ "CASE WHEN cast(art.xvalortexto9 as varchar)IS NULL OR cast(art.xvalortexto9 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalortexto9 as varchar) END "
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
									+ "ELSE ' / ' + cast(art.xvalorint6 as varchar) END"
									+ "CASE WHEN cast(art.xvalorint7 as varchar)IS NULL OR cast(art.xvalorint7 as varchar)= '' THEN '' "
									+ "ELSE ' / ' + cast(art.xvalorint7 as varchar) END"
									+ "CASE WHEN cast(art.xvalorint8 as varchar)IS NULL OR cast(art.xvalorint8 as varchar)= '' THEN '' "
									+ "ELSE ' / ' + cast(art.xvalorint8 as varchar) END"
									+ "CASE WHEN cast(art.xvalorint9 as varchar)IS NULL OR cast(art.xvalorint9 as varchar)= '' THEN '' "
									+ "ELSE ' / ' + cast(art.xvalorint9 as varchar) END"
									+ "CASE WHEN cast(art.xvalorint10 as varchar)IS NULL OR cast(art.xvalorint10 as varchar)= '' THEN '' "
									+ "ELSE ' / ' + cast(art.xvalorint10 as varchar) END" + " when 4 then "
									+ "CASE WHEN cast(art.xvalordecimal1 as varchar) IS NULL OR cast(art.xvalordecimal1 as varchar)= '' "
									+ "THEN '' ELSE cast(art.xvalordecimal1 as varchar)END +"
									+ "CASE WHEN cast(art.xvalordecimal2 as varchar) IS NULL OR cast(art.xvalordecimal2 as varchar)= ''"
									+ " THEN '' ELSE ' / ' + cast(art.xvalordecimal2 as varchar)END +"
									+ "CASE WHEN cast(art.xvalordecimal3 as varchar)IS NULL OR cast(art.xvalordecimal3 as varchar)= ''"
									+ " THEN '' ELSE ' / ' + cast(art.xvalordecimal3 as varchar) END +"
									+ "CASE WHEN cast(art.xvalordecimal4 as varchar)IS NULL OR cast(art.xvalordecimal4 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalordecimal4 as varchar) END +"
									+ "CASE WHEN cast(art.xvalordecimal5 as varchar)IS NULL OR cast(art.xvalordecimal5 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalordecimal5 as varchar) END +"
									+ "CASE WHEN cast(art.xvalordecimal6 as varchar)IS NULL OR cast(art.xvalordecimal6 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalordecimal6 as varchar) END "
									+ "CASE WHEN cast(art.xvalordecimal7 as varchar)IS NULL OR cast(art.xvalordecimal7 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalordecimal7 as varchar) END "
									+ "CASE WHEN cast(art.xvalordecimal8 as varchar)IS NULL OR cast(art.xvalordecimal8 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalordecimal8 as varchar) END "
									+ "CASE WHEN cast(art.xvalordecimal9 as varchar)IS NULL OR cast(art.xvalordecimal9 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalordecimal9 as varchar) END "
									+ "CASE WHEN cast(art.xvalordecimal10 as varchar)IS NULL OR cast(art.xvalordecimal10 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalordecimal10 as varchar) END " + "end as valores"
									+ ", CASE WHEN cast(carm.xnombre1 as varchar) IS NULL OR cast(carm.xnombre1  as varchar)= '' THEN '' ELSE cast(carm.xnombre1  as varchar)END +"
									+ " CASE WHEN cast(carm.xnombre2 as varchar) IS NULL OR cast(carm.xnombre2  as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre2  as varchar)END +"
									+ " CASE WHEN cast(carm.xnombre3  as varchar)IS NULL OR cast(carm.xnombre3 as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre3 as varchar) END +"
									+ " CASE WHEN cast(carm.xnombre4 as varchar)IS NULL OR cast(carm.xnombre4  as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre4  as varchar) END +"
									+ " CASE WHEN cast(carm.xnombre5 as varchar)IS NULL OR cast(carm.xnombre5 as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre5 as varchar) END +"
									+ " CASE WHEN cast(carm.xnombre6 as varchar)IS NULL OR cast(carm.xnombre6 as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre6 as varchar) END "
									+ " CASE WHEN cast(carm.xnombre7 as varchar)IS NULL OR cast(carm.xnombre7 as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre7 as varchar) END "
									+ " CASE WHEN cast(carm.xnombre8 as varchar)IS NULL OR cast(carm.xnombre8 as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre8 as varchar) END "
									+ " CASE WHEN cast(carm.xnombre9 as varchar)IS NULL OR cast(carm.xnombre9 as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre9 as varchar) END "
									+ " CASE WHEN cast(carm.xnombre10 as varchar)IS NULL OR cast(carm.xnombre10 as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre10 as varchar) END "

									+ "as nombres" + " from " + connSdic.translateTable("s_art_carac") + " art "
									+ " inner join " + connSdic.translateTable("s_caracteristicas")
									+ " car on art.xcaracteristica_id=car.xcaracteristica_id " + " inner join "
									+ connSdic.translateTable("s_caracteristicasmlg")
									+ " carm on carm.xcaracteristica_id=car.xcaracteristica_id" + " inner join "
									+ connSdic.translateTable("pl_articulos")
									+ " gen on gen.xarticulo_id = art.xarticulo_id and gen.xempresa_id = art.xempresa_id"
									+ " inner join " + connSdic.translateTable("s_carac_fam")
									+ " fam on fam.xempresa_id = art.xempresa_id and fam.xcaracteristica_id = car.xcaracteristica_id"
									+ " left outer join " + connSdic.translateTable("sul_art_listas")
									+ " lista on lista.xlista_id=car.xlista1 and art.xvalorlista1=lista.xlinea_id "
									+ " left outer join imp.sul_art_listasmlg mlg on mlg.xlista_id=lista.xlista_id and mlg.xlinea_id=lista.xlinea_id"
									+ " where  art.xempresa_id='" + sEmpresa + "' and  art.xarticulo_id='" + sArticulo
									+ "' "
									+ " and gen.xfamilia_produc=fam.xfamilia_id and gen.xtecnologia = fam.xssfamilia_id"
									+ " and car.xbaja=0 " + " and car.xcaracteristica_id='" + sCaracteristicaEstado
									+ "'" + " and art.xsituacion_dsp='" + sSituacion1 + "'";
							if (!(sSituacion2 == null || sSituacion2.equals(""))) {
								sql += "union"
										+ " select carm.xdescripcion,carm.xnombre1, carm.xnombre2,art.xsituacion_dsp situacionArt,gen.xfamilia_produc,gen.xtecnologia,gen.xsituacion_dsp,car.xapartado_id,car.xtipo_valor,art.xempresa_id,art.xarticulo_id,art.xcaracteristica_id,mlg.xdescripcion"
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
										+ " ELSE ' / ' + cast(art.xvalortexto6 as varchar) END " + "when 3 then "
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
										+ "ELSE ' / ' + cast(art.xvalorint6 as varchar) END when 4 then "
										+ "CASE WHEN cast(art.xvalordecimal1 as varchar) IS NULL OR cast(art.xvalordecimal1 as varchar)= '' "
										+ "THEN '' ELSE cast(art.xvalordecimal1 as varchar)END +"
										+ "CASE WHEN cast(art.xvalordecimal2 as varchar) IS NULL OR cast(art.xvalordecimal2 as varchar)= ''"
										+ " THEN '' ELSE ' / ' + cast(art.xvalordecimal2 as varchar)END +"
										+ "CASE WHEN cast(art.xvalordecimal3 as varchar)IS NULL OR cast(art.xvalordecimal3 as varchar)= ''"
										+ " THEN '' ELSE ' / ' + cast(art.xvalordecimal3 as varchar) END +"
										+ "CASE WHEN cast(art.xvalordecimal4 as varchar)IS NULL OR cast(art.xvalordecimal4 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalordecimal4 as varchar) END +"
										+ "CASE WHEN cast(art.xvalordecimal5 as varchar)IS NULL OR cast(art.xvalordecimal5 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalordecimal5 as varchar) END +"
										+ "CASE WHEN cast(art.xvalordecimal6 as varchar)IS NULL OR cast(art.xvalordecimal6 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalordecimal6 as varchar) END end as valores"
										+ ", CASE WHEN cast(carm.xnombre1 as varchar) IS NULL OR cast(carm.xnombre1  as varchar)= '' THEN '' ELSE cast(carm.xnombre1  as varchar)END +"
										+ " CASE WHEN cast(carm.xnombre2 as varchar) IS NULL OR cast(carm.xnombre2  as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre2  as varchar)END +"
										+ " CASE WHEN cast(carm.xnombre3  as varchar)IS NULL OR cast(carm.xnombre3 as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre3 as varchar) END +"
										+ " CASE WHEN cast(carm.xnombre4 as varchar)IS NULL OR cast(carm.xnombre4  as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre4  as varchar) END +"
										+ " CASE WHEN cast(carm.xnombre5 as varchar)IS NULL OR cast(carm.xnombre5 as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre5 as varchar) END +"
										+ " CASE WHEN cast(carm.xnombre6 as varchar)IS NULL OR cast(carm.xnombre6 as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre6 as varchar) END as nombres"
										+ " from " + connSdic.translateTable("s_art_carac") + " art " + " inner join "
										+ connSdic.translateTable("s_caracteristicas")
										+ " car on art.xcaracteristica_id=car.xcaracteristica_id " + " inner join "
										+ connSdic.translateTable("s_caracteristicasmlg")
										+ " carm on carm.xcaracteristica_id=car.xcaracteristica_id" + " inner join "
										+ connSdic.translateTable("pl_articulos")
										+ " gen on gen.xarticulo_id = art.xarticulo_id and gen.xempresa_id = art.xempresa_id"
										+ " inner join " + connSdic.translateTable("s_carac_fam")
										+ " fam on fam.xempresa_id = art.xempresa_id and fam.xcaracteristica_id = car.xcaracteristica_id"
										+ " left outer join " + connSdic.translateTable("sul_art_listas")
										+ " lista on lista.xlista_id=car.xlista1 and art.xvalorlista1=lista.xlinea_id "
										+ " left outer join imp.sul_art_listasmlg mlg on mlg.xlista_id=lista.xlista_id and mlg.xlinea_id=lista.xlinea_id"
										+ " where  art.xempresa_id='" + sEmpresa + "' and  art.xarticulo_id='"
										+ sArticulo + "' "
										+ " and gen.xfamilia_produc=fam.xfamilia_id and gen.xtecnologia = fam.xssfamilia_id"
										+ " and car.xbaja=0 " + " and car.xcaracteristica_id='" + sCaracteristicaEstado
										+ "'" + " and art.xsituacion_dsp='" + sSituacion2 + "'";
							}
							if (!(sSituacion3 == null || sSituacion3.equals(""))) {
								sql += "union"
										+ " select carm.xdescripcion,carm.xnombre1, carm.xnombre2,art.xsituacion_dsp situacionArt,gen.xfamilia_produc,gen.xtecnologia,gen.xsituacion_dsp,car.xapartado_id,car.xtipo_valor,art.xempresa_id,art.xarticulo_id,art.xcaracteristica_id,mlg.xdescripcion"
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
										+ " ELSE ' / ' + cast(art.xvalortexto6 as varchar) END " + "when 3 then "
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
										+ "ELSE ' / ' + cast(art.xvalorint6 as varchar) END when 4 then "
										+ "CASE WHEN cast(art.xvalordecimal1 as varchar) IS NULL OR cast(art.xvalordecimal1 as varchar)= '' "
										+ "THEN '' ELSE cast(art.xvalordecimal1 as varchar)END +"
										+ "CASE WHEN cast(art.xvalordecimal2 as varchar) IS NULL OR cast(art.xvalordecimal2 as varchar)= ''"
										+ " THEN '' ELSE ' / ' + cast(art.xvalordecimal2 as varchar)END +"
										+ "CASE WHEN cast(art.xvalordecimal3 as varchar)IS NULL OR cast(art.xvalordecimal3 as varchar)= ''"
										+ " THEN '' ELSE ' / ' + cast(art.xvalordecimal3 as varchar) END +"
										+ "CASE WHEN cast(art.xvalordecimal4 as varchar)IS NULL OR cast(art.xvalordecimal4 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalordecimal4 as varchar) END +"
										+ "CASE WHEN cast(art.xvalordecimal5 as varchar)IS NULL OR cast(art.xvalordecimal5 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalordecimal5 as varchar) END +"
										+ "CASE WHEN cast(art.xvalordecimal6 as varchar)IS NULL OR cast(art.xvalordecimal6 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalordecimal6 as varchar) END end as valores"
										+ ", CASE WHEN cast(carm.xnombre1 as varchar) IS NULL OR cast(carm.xnombre1  as varchar)= '' THEN '' ELSE cast(carm.xnombre1  as varchar)END +"
										+ " CASE WHEN cast(carm.xnombre2 as varchar) IS NULL OR cast(carm.xnombre2  as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre2  as varchar)END +"
										+ " CASE WHEN cast(carm.xnombre3  as varchar)IS NULL OR cast(carm.xnombre3 as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre3 as varchar) END +"
										+ " CASE WHEN cast(carm.xnombre4 as varchar)IS NULL OR cast(carm.xnombre4  as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre4  as varchar) END +"
										+ " CASE WHEN cast(carm.xnombre5 as varchar)IS NULL OR cast(carm.xnombre5 as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre5 as varchar) END +"
										+ " CASE WHEN cast(carm.xnombre6 as varchar)IS NULL OR cast(carm.xnombre6 as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre6 as varchar) END as nombres"
										+ " from " + connSdic.translateTable("s_art_carac") + " art " + " inner join "
										+ connSdic.translateTable("s_caracteristicas")
										+ " car on art.xcaracteristica_id=car.xcaracteristica_id " + " inner join "
										+ connSdic.translateTable("s_caracteristicasmlg")
										+ " carm on carm.xcaracteristica_id=car.xcaracteristica_id" + " inner join "
										+ connSdic.translateTable("pl_articulos")
										+ " gen on gen.xarticulo_id = art.xarticulo_id and gen.xempresa_id = art.xempresa_id"
										+ " inner join " + connSdic.translateTable("s_carac_fam")
										+ " fam on fam.xempresa_id = art.xempresa_id and fam.xcaracteristica_id = car.xcaracteristica_id"
										+ " left outer join " + connSdic.translateTable("sul_art_listas")
										+ " lista on lista.xlista_id=car.xlista1 and art.xvalorlista1=lista.xlinea_id "
										+ " left outer join imp.sul_art_listasmlg mlg on mlg.xlista_id=lista.xlista_id and mlg.xlinea_id=lista.xlinea_id"
										+ " where  art.xempresa_id='" + sEmpresa + "' and  art.xarticulo_id='"
										+ sArticulo + "'"
										+ " and gen.xfamilia_produc=fam.xfamilia_id and gen.xtecnologia = fam.xssfamilia_id"
										+ " and car.xbaja=0 " + " and car.xcaracteristica_id='" + sCaracteristicaEstado
										+ "'" + " and art.xsituacion_dsp='" + sSituacion3 + "'";
							}
							if (!(sSituacion4 == null || sSituacion4.equals(""))) {
								sql += "union"
										+ " select carm.xdescripcion,carm.xnombre1, carm.xnombre2,art.xsituacion_dsp situacionArt,gen.xfamilia_produc,gen.xtecnologia,gen.xsituacion_dsp,car.xapartado_id,car.xtipo_valor,art.xempresa_id,art.xarticulo_id,art.xcaracteristica_id,mlg.xdescripcion"
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
										+ " ELSE ' / ' + cast(art.xvalortexto6 as varchar) END " + "when 3 then "
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
										+ "ELSE ' / ' + cast(art.xvalorint6 as varchar) END when 4 then "
										+ "CASE WHEN cast(art.xvalordecimal1 as varchar) IS NULL OR cast(art.xvalordecimal1 as varchar)= '' "
										+ "THEN '' ELSE cast(art.xvalordecimal1 as varchar)END +"
										+ "CASE WHEN cast(art.xvalordecimal2 as varchar) IS NULL OR cast(art.xvalordecimal2 as varchar)= ''"
										+ " THEN '' ELSE ' / ' + cast(art.xvalordecimal2 as varchar)END +"
										+ "CASE WHEN cast(art.xvalordecimal3 as varchar)IS NULL OR cast(art.xvalordecimal3 as varchar)= ''"
										+ " THEN '' ELSE ' / ' + cast(art.xvalordecimal3 as varchar) END +"
										+ "CASE WHEN cast(art.xvalordecimal4 as varchar)IS NULL OR cast(art.xvalordecimal4 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalordecimal4 as varchar) END +"
										+ "CASE WHEN cast(art.xvalordecimal5 as varchar)IS NULL OR cast(art.xvalordecimal5 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalordecimal5 as varchar) END +"
										+ "CASE WHEN cast(art.xvalordecimal6 as varchar)IS NULL OR cast(art.xvalordecimal6 as varchar)= '' THEN ''"
										+ " ELSE ' / ' + cast(art.xvalordecimal6 as varchar) END end as valores"
										+ ", CASE WHEN cast(carm.xnombre1 as varchar) IS NULL OR cast(carm.xnombre1  as varchar)= '' THEN '' ELSE cast(carm.xnombre1  as varchar)END +"
										+ " CASE WHEN cast(carm.xnombre2 as varchar) IS NULL OR cast(carm.xnombre2  as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre2  as varchar)END +"
										+ " CASE WHEN cast(carm.xnombre3  as varchar)IS NULL OR cast(carm.xnombre3 as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre3 as varchar) END +"
										+ " CASE WHEN cast(carm.xnombre4 as varchar)IS NULL OR cast(carm.xnombre4  as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre4  as varchar) END +"
										+ " CASE WHEN cast(carm.xnombre5 as varchar)IS NULL OR cast(carm.xnombre5 as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre5 as varchar) END +"
										+ " CASE WHEN cast(carm.xnombre6 as varchar)IS NULL OR cast(carm.xnombre6 as varchar)= '' THEN '' ELSE ' / ' + cast(carm.xnombre6 as varchar) END as nombres"
										+ " from " + connSdic.translateTable("s_art_carac") + " art " + " inner join "
										+ connSdic.translateTable("s_caracteristicas")
										+ " car on art.xcaracteristica_id=car.xcaracteristica_id " + " inner join "
										+ connSdic.translateTable("s_caracteristicasmlg")
										+ " carm on carm.xcaracteristica_id=car.xcaracteristica_id " + " inner join "
										+ connSdic.translateTable("pl_articulos")
										+ " gen on gen.xarticulo_id = art.xarticulo_id and gen.xempresa_id = art.xempresa_id"
										+ " inner join " + connSdic.translateTable("s_carac_fam")
										+ " fam on fam.xempresa_id = art.xempresa_id and fam.xcaracteristica_id = car.xcaracteristica_id"
										+ " left outer join " + connSdic.translateTable("sul_art_listas")
										+ " lista on lista.xlista_id=car.xlista1 and art.xvalorlista1=lista.xlinea_id "
										+ " left outer join imp.sul_art_listasmlg mlg on mlg.xlista_id=lista.xlista_id and mlg.xlinea_id=lista.xlinea_id"
										+ " where  art.xempresa_id='" + sEmpresa + "' and  art.xarticulo_id='"
										+ sArticulo + "'"
										+ " and gen.xfamilia_produc=fam.xfamilia_id and gen.xtecnologia = fam.xssfamilia_id"
										+ " and car.xbaja=0 " + " and car.xcaracteristica_id='" + sCaracteristicaEstado
										+ "'" + " and art.xsituacion_dsp='" + sSituacion4 + "'";
							}

							try (DAResultSet oRes = session.getConnectionData().openSQL(sql)) {
								boolean insertadoCertificado = false;
								boolean insertadoGeneral = false;
								boolean insertadoPack = false;
								boolean insertadoProductInf = false;
								boolean insertadoComponentes = false;
								boolean insertadoLed = false;
								boolean insertadoLedmain = false;
								boolean insertadoDriver = false;
								boolean insertadoControl = false;
								boolean insertadoFan = false;
								boolean insertadoDimension = false;
								boolean insertadoRemote = false;
								boolean insertadoTest = false;
								boolean insertadoDatosChequeo = false;

								while (oRes.moveNext()) {
									String sSituacionCarac = oRes.getString("situacionArt");
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
									String sNombre1 = oRes.getString("xnombre1");
									String sNombre2 = oRes.getString("xnombre2");

									valores = oRes.getString("valores");
									nombres = oRes.getString("nombres");
									String sDescripcion = oRes.getString("xdescripcion");
									String sCaracteristicas = oRes.getString("xcaracteristica_id");
									String sTipo = oRes.getString("xtipo_valor");
									String sApartado = oRes.getString("xapartado_id");
									if (!(sApartado == null || sApartado.equals(""))) {

										// Filtramos por tipo de apartado

										// product information

										if (sApartado.equals("01")) {
											if (!(sEstados.contains(sSituacionColumna1))) {
												getItem(ITEMS.txtvalormaestro_prod_inf).setValue(iProductInf,
														"No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna2))) {
												getItem(ITEMS.txtvalormaestro_prod_inf2).setValue(iProductInf,
														"No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna3))) {
												getItem(ITEMS.txtvalormaestro_prod_inf3).setValue(iProductInf,
														"No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna4))) {
												getItem(ITEMS.txtvalormaestro_prod_inf4).setValue(iProductInf,
														"No aplica");
											}
											if (sSituacionColumna1.equals(sSituacionCarac)) { // Comprobamos cuantos se
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_prod_inf).setValue(iProductInf,
																nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_prod_inf).setValue(iProductInf,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_prod_inf).setValue(iProductInf,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_prod_in).setValue(iProductInf,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_prod_in).setDescription(iProductInf,
															sDescripcion);
													insertadoProductInf = true;
												} else {
													// para rellenar de la columa 1 a la 4
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_prod_inf).setValue(iProductInf,
																nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_prod_inf).setValue(iProductInf,
																valores);

													} else {
														getItem(ITEMS.txtvalormaestro_prod_inf).setValue(iProductInf,
																"");

													}
													getItem(ITEMS.txtcaracteristica_prod_in).setValue(iProductInf,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_prod_in).setDescription(iProductInf,
															sDescripcion);
													insertadoProductInf = true; // Colocamos bandera para que solo
																				// aumente
																				// la linea cuando insertemos los 4
																				// valores
																				// y no se creen lineas diferentes.
												}
											} else if (sSituacionColumna2.equals(sSituacionCarac)) {

												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_prod_inf).setValue(iProductInf,
																nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_prod_inf2).setValue(iProductInf,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_prod_inf2).setValue(iProductInf,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_prod_in).setValue(iProductInf,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_prod_in).setDescription(iProductInf,
															sDescripcion);
													insertadoProductInf = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_prod_inf).setValue(iProductInf,
																nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_prod_inf2).setValue(iProductInf,
																valores);

													} else {
														getItem(ITEMS.txtvalormaestro_prod_inf2).setValue(iProductInf,
																"");

													}
													getItem(ITEMS.txtcaracteristica_prod_in).setValue(iProductInf,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_prod_in).setDescription(iProductInf,
															sDescripcion);
													insertadoProductInf = true;
												}
											} else if (sSituacionColumna3.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_prod_inf).setValue(iProductInf,
																nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_prod_inf3).setValue(iProductInf,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_prod_inf3).setValue(iProductInf,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_prod_in).setValue(iProductInf,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_prod_in).setDescription(iProductInf,
															sDescripcion);
													insertadoProductInf = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_prod_inf).setValue(iProductInf,
																nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_prod_inf3).setValue(iProductInf,
																valores);

													} else {
														getItem(ITEMS.txtvalormaestro_prod_inf3).setValue(iProductInf,
																"");

													}
													getItem(ITEMS.txtcaracteristica_prod_in).setValue(iProductInf,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_prod_in).setDescription(iProductInf,
															sDescripcion);
													insertadoProductInf = true;
												}
											} else if (sSituacionColumna4.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_prod_inf).setValue(iProductInf,
																nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_prod_inf4).setValue(iProductInf,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_prod_inf4).setValue(iProductInf,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_prod_in).setValue(iProductInf,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_prod_in).setDescription(iProductInf,
															sDescripcion);
													insertadoProductInf = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_prod_inf).setValue(iProductInf,
																nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_prod_inf4).setValue(iProductInf,
																valores);

													} else {
														getItem(ITEMS.txtvalormaestro_prod_inf4).setValue(iProductInf,
																"");
													}
													getItem(ITEMS.txtcaracteristica_prod_in).setValue(iProductInf,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_prod_in).setDescription(iProductInf,
															sDescripcion);
													insertadoProductInf = true;
												}
											}
										}
										// certificados
										if (sApartado.equals("02")) {
											if (!(sEstados.contains(sSituacionColumna1))) {
												getItem(ITEMS.txtvalormaestro_certif).setValue(iCertificados,
														"No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna2))) {
												getItem(ITEMS.txtvalormaestro_certif2).setValue(iCertificados,
														"No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna3))) {
												getItem(ITEMS.txtvalormaestro_certif3).setValue(iCertificados,
														"No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna4))) {
												getItem(ITEMS.txtvalormaestro_certif4).setValue(iCertificados,
														"No aplica");
											}
											if (sSituacionColumna1.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_certif).setValue(iCertificados,
																nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_certif).setValue(iCertificados,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_certif).setValue(iCertificados,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_certif).setValue(iCertificados,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_certif)
															.setDescription(iCertificados, sDescripcion);
													insertadoCertificado = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_certif).setValue(iCertificados,
																nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_certif).setValue(iCertificados,
																valores);
														getItem(ITEMS.txtcaracteristica_certif).setValue(iCertificados,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_certif)
																.setDescription(iCertificados, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_certif).setValue(iCertificados,
																"");
														getItem(ITEMS.txtcaracteristica_certif).setValue(iCertificados,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_certif)
																.setDescription(iCertificados, sDescripcion);
													}
													insertadoCertificado = true;
												}
											} else if (sSituacionColumna2.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_certif).setValue(iCertificados,
																nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_certif2).setValue(iCertificados,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_certif2).setValue(iCertificados,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_certif).setValue(iCertificados,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_certif)
															.setDescription(iCertificados, sDescripcion);
													insertadoCertificado = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_certif).setValue(iCertificados,
																nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_certif2).setValue(iCertificados,
																valores);
														getItem(ITEMS.txtcaracteristica_certif).setValue(iCertificados,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_certif)
																.setDescription(iCertificados, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_certif2).setValue(iCertificados,
																"");
														getItem(ITEMS.txtcaracteristica_certif).setValue(iCertificados,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_certif)
																.setDescription(iCertificados, sDescripcion);
													}
													insertadoCertificado = true;
												}
											} else if (sSituacionColumna3.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_certif).setValue(iCertificados,
																nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_certif3).setValue(iCertificados,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_certif3).setValue(iCertificados,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_certif).setValue(iCertificados,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_certif)
															.setDescription(iCertificados, sDescripcion);
													insertadoCertificado = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_certif).setValue(iCertificados,
																nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_certif3).setValue(iCertificados,
																valores);
														getItem(ITEMS.txtcaracteristica_certif).setValue(iCertificados,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_certif)
																.setDescription(iCertificados, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_certif3).setValue(iCertificados,
																"");
														getItem(ITEMS.txtcaracteristica_certif).setValue(iCertificados,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_certif)
																.setDescription(iCertificados, sDescripcion);
													}
													insertadoCertificado = true;
												}
											} else if (sSituacionColumna4.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_certif).setValue(iCertificados,
																nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_certif4).setValue(iCertificados,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_certif4).setValue(iCertificados,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_certif).setValue(iCertificados,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_certif)
															.setDescription(iCertificados, sDescripcion);
													insertadoCertificado = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_certif).setValue(iCertificados,
																nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_certif4).setValue(iCertificados,
																valores);
														getItem(ITEMS.txtcaracteristica_certif).setValue(iCertificados,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_certif)
																.setDescription(iCertificados, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_certif4).setValue(iCertificados,
																"");
														getItem(ITEMS.txtcaracteristica_certif).setValue(iCertificados,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_certif)
																.setDescription(iCertificados, sDescripcion);
													}
													insertadoCertificado = true;
												}
											}
										}
										// packaging
										if (sApartado.equals("03")) {
											if (!(sEstados.contains(sSituacionColumna1))) {
												getItem(ITEMS.txtvalormaestro_pack).setValue(iPack, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna2))) {
												getItem(ITEMS.txtvalormaestro_pack2).setValue(iPack, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna3))) {
												getItem(ITEMS.txtvalormaestro_pack3).setValue(iPack, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna4))) {
												getItem(ITEMS.txtvalormaestro_pack4).setValue(iPack, "No aplica");
											}
											if (sSituacionColumna1.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_pack).setValue(iPack, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_pack).setValue(iPack, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_pack).setValue(iPack, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_pack).setValue(iPack,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_pack).setDescription(iPack,
															sDescripcion);
													insertadoPack = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_pack).setValue(iPack, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_pack).setValue(iPack, valores);
														getItem(ITEMS.txtcaracteristica_pack).setValue(iPack,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_pack).setDescription(iPack,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_pack).setValue(iPack, "");
														getItem(ITEMS.txtcaracteristica_pack).setValue(iPack,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_pack).setDescription(iPack,
																sDescripcion);
													}
													insertadoPack = true;
												}
											} else if (sSituacionColumna2.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_pack).setValue(iPack, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_pack2).setValue(iPack, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_pack2).setValue(iPack, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_pack).setValue(iPack,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_pack).setDescription(iPack,
															sDescripcion);
													insertadoPack = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_pack).setValue(iPack, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_pack2).setValue(iPack, valores);
														getItem(ITEMS.txtcaracteristica_pack).setValue(iPack,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_pack).setDescription(iPack,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_pack2).setValue(iPack, "");
														getItem(ITEMS.txtcaracteristica_pack).setValue(iPack,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_pack).setDescription(iPack,
																sDescripcion);
													}
													insertadoPack = true;
												}
											} else if (sSituacionColumna3.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_pack).setValue(iPack, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_pack3).setValue(iPack, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_pack3).setValue(iPack, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_pack).setValue(iPack,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_pack).setDescription(iPack,
															sDescripcion);
													insertadoPack = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_pack).setValue(iPack, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_pack3).setValue(iPack, valores);
														getItem(ITEMS.txtcaracteristica_pack).setValue(iPack,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_pack).setDescription(iPack,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_pack3).setValue(iPack, "");
														getItem(ITEMS.txtcaracteristica_pack).setValue(iPack,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_pack).setDescription(iPack,
																sDescripcion);
													}
													insertadoPack = true;
												}
											} else if (sSituacionColumna4.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_pack).setValue(iPack, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_pack4).setValue(iPack, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_pack4).setValue(iPack, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_pack).setValue(iPack,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_pack).setDescription(iPack,
															sDescripcion);
													insertadoPack = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_pack).setValue(iPack, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_pack4).setValue(iPack, valores);
														getItem(ITEMS.txtcaracteristica_pack).setValue(iPack,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_pack).setDescription(iPack,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_pack4).setValue(iPack, "");
														getItem(ITEMS.txtcaracteristica_pack).setValue(iPack,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_pack).setDescription(iPack,
																sDescripcion);
													}
													insertadoPack = true;
												}
											}
										}
										// componentes
										if (sApartado.equals("04")) {
											if (!(sEstados.contains(sSituacionColumna1))) {
												getItem(ITEMS.txtvalormaestro_comp).setValue(iComponentes, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna2))) {
												getItem(ITEMS.txtvalormaestro_comp2).setValue(iComponentes,
														"No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna3))) {
												getItem(ITEMS.txtvalormaestro_comp3).setValue(iComponentes,
														"No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna4))) {
												getItem(ITEMS.txtvalormaestro_comp4).setValue(iComponentes,
														"No aplica");
											}
											if (sSituacionColumna1.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_comp).setValue(iComponentes, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_comp).setValue(iComponentes,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_comp).setValue(iComponentes,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_comp).setValue(iComponentes,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_comp).setDescription(iComponentes,
															sDescripcion);
													insertadoComponentes = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_comp).setValue(iComponentes, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_comp).setValue(iComponentes,
																valores);
														getItem(ITEMS.txtcaracteristica_comp).setValue(iComponentes,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_comp)
																.setDescription(iComponentes, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_comp).setValue(iComponentes, "");
														getItem(ITEMS.txtcaracteristica_comp).setValue(iComponentes,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_comp)
																.setDescription(iComponentes, sDescripcion);
													}
													insertadoComponentes = true;
												}
											} else if (sSituacionColumna2.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_comp).setValue(iComponentes, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_comp2).setValue(iComponentes,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_comp2).setValue(iComponentes,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_comp).setValue(iComponentes,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_comp).setDescription(iComponentes,
															sDescripcion);
													insertadoComponentes = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_comp).setValue(iComponentes, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_comp2).setValue(iComponentes,
																valores);
														getItem(ITEMS.txtcaracteristica_comp).setValue(iComponentes,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_comp)
																.setDescription(iComponentes, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_comp2).setValue(iComponentes, "");
														getItem(ITEMS.txtcaracteristica_comp).setValue(iComponentes,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_comp)
																.setDescription(iComponentes, sDescripcion);
													}
													insertadoComponentes = true;
												}
											} else if (sSituacionColumna3.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_comp).setValue(iComponentes, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_comp3).setValue(iComponentes,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_comp3).setValue(iComponentes,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_comp).setValue(iComponentes,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_comp).setDescription(iComponentes,
															sDescripcion);
													insertadoComponentes = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_comp).setValue(iComponentes, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_comp3).setValue(iComponentes,
																valores);
														getItem(ITEMS.txtcaracteristica_comp).setValue(iComponentes,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_comp)
																.setDescription(iComponentes, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_comp3).setValue(iComponentes, "");
														getItem(ITEMS.txtcaracteristica_comp).setValue(iComponentes,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_comp)
																.setDescription(iComponentes, sDescripcion);
													}
													insertadoComponentes = true;
												}
											} else if (sSituacionColumna4.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_comp).setValue(iComponentes, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_comp4).setValue(iComponentes,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_comp4).setValue(iComponentes,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_comp).setValue(iComponentes,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_comp).setDescription(iComponentes,
															sDescripcion);
													insertadoComponentes = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_comp).setValue(iComponentes, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_comp4).setValue(iComponentes,
																valores);
														getItem(ITEMS.txtcaracteristica_comp).setValue(iComponentes,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_comp)
																.setDescription(iComponentes, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_comp4).setValue(iComponentes, "");
														getItem(ITEMS.txtcaracteristica_comp).setValue(iComponentes,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_comp)
																.setDescription(iComponentes, sDescripcion);
													}
													insertadoComponentes = true;
												}
											}
										}
										// General data
										if (sApartado.equals("05")) {
											if (!(sEstados.contains(sSituacionColumna1))) {
												getItem(ITEMS.txtvalormaestro_gen).setValue(iGeneral, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna2))) {
												getItem(ITEMS.txtvalormaestro_gen2).setValue(iGeneral, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna3))) {
												getItem(ITEMS.txtvalormaestro_gen3).setValue(iGeneral, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna4))) {
												getItem(ITEMS.txtvalormaestro_gen4).setValue(iGeneral, "No aplica");
											}
											if (sSituacionColumna1.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_gen).setValue(iGeneral, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_gen).setValue(iGeneral, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_gen).setValue(iGeneral, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_gen).setValue(iGeneral,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_gen).setDescription(iGeneral,
															sDescripcion);
													insertadoGeneral = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_gen).setValue(iGeneral, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_gen).setValue(iGeneral, valores);
														getItem(ITEMS.txtcaracteristica_gen).setValue(iGeneral,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_gen).setDescription(iGeneral,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_gen).setValue(iGeneral, "");
														getItem(ITEMS.txtcaracteristica_gen).setValue(iGeneral,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_gen).setDescription(iGeneral,
																sDescripcion);
													}
													insertadoGeneral = true;
												}
											} else if (sSituacionColumna2.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_gen).setValue(iGeneral, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_gen2).setValue(iGeneral,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_gen2).setValue(iGeneral,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_gen).setValue(iGeneral,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_gen).setDescription(iGeneral,
															sDescripcion);
													insertadoGeneral = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_gen).setValue(iGeneral, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_gen2).setValue(iGeneral, valores);
														getItem(ITEMS.txtcaracteristica_gen).setValue(iGeneral,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_gen).setDescription(iGeneral,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_gen2).setValue(iGeneral, "");
														getItem(ITEMS.txtcaracteristica_gen).setValue(iGeneral,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_gen).setDescription(iGeneral,
																sDescripcion);
													}
													insertadoGeneral = true;
												}

											} else if (sSituacionColumna3.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_gen).setValue(iGeneral, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_gen3).setValue(iGeneral,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_gen3).setValue(iGeneral,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_gen).setValue(iGeneral,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_gen).setDescription(iGeneral,
															sDescripcion);
													insertadoGeneral = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_gen).setValue(iGeneral, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_gen3).setValue(iGeneral, valores);
														getItem(ITEMS.txtcaracteristica_gen).setValue(iGeneral,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_gen).setDescription(iGeneral,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_gen3).setValue(iGeneral, "");
														getItem(ITEMS.txtcaracteristica_gen).setValue(iGeneral,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_gen).setDescription(iGeneral,
																sDescripcion);
													}
													insertadoGeneral = true;
												}
											} else if (sSituacionColumna4.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_gen).setValue(iGeneral, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_gen4).setValue(iGeneral,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_gen4).setValue(iGeneral,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_gen).setValue(iGeneral,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_gen).setDescription(iGeneral,
															sDescripcion);
													insertadoGeneral = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_gen).setValue(iGeneral, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_gen4).setValue(iGeneral, valores);
														getItem(ITEMS.txtcaracteristica_gen).setValue(iGeneral,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_gen).setDescription(iGeneral,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_gen4).setValue(iGeneral, "");
														getItem(ITEMS.txtcaracteristica_gen).setValue(iGeneral,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_gen).setDescription(iGeneral,
																sDescripcion);
													}
													insertadoGeneral = true;
												}
											}
										}
										// Led Data
										if (sApartado.equals("06")) {
											if (!(sEstados.contains(sSituacionColumna1))) {
												getItem(ITEMS.txtvalormaestro_led).setValue(iLed, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna2))) {
												getItem(ITEMS.txtvalormaestro_led2).setValue(iLed, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna3))) {
												getItem(ITEMS.txtvalormaestro_led3).setValue(iLed, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna4))) {
												getItem(ITEMS.txtvalormaestro_led4).setValue(iLed, "No aplica");
											}
											if (sSituacionColumna1.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_led).setValue(iLed, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_led).setValue(iLed, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_led).setValue(iLed, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_led).setValue(iLed,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_led).setDescription(iLed,
															sDescripcion);
													insertadoLed = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_led).setValue(iLed, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_led).setValue(iLed, valores);
														getItem(ITEMS.txtcaracteristica_led).setValue(iLed,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_led).setDescription(iLed,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_led).setValue(iLed, "");
														getItem(ITEMS.txtcaracteristica_led).setValue(iLed,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_led).setDescription(iLed,
																sDescripcion);
													}
													insertadoLed = true;
												}
											} else if (sSituacionColumna2.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_led).setValue(iLed, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_led2).setValue(iLed, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_led2).setValue(iLed, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_led).setValue(iLed,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_led).setDescription(iLed,
															sDescripcion);
													insertadoLed = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_led).setValue(iLed, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_led2).setValue(iLed, valores);
														getItem(ITEMS.txtcaracteristica_led).setValue(iLed,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_led).setDescription(iLed,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_led2).setValue(iLed, "");
														getItem(ITEMS.txtcaracteristica_led).setValue(iLed,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_led).setDescription(iLed,
																sDescripcion);
													}
													insertadoLed = true;
												}
											} else if (sSituacionColumna3.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_led).setValue(iLed, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_led3).setValue(iLed, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_led3).setValue(iLed, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_led).setValue(iLed,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_led).setDescription(iLed,
															sDescripcion);
													insertadoLed = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_led).setValue(iLed, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_led3).setValue(iLed, valores);
														getItem(ITEMS.txtcaracteristica_led).setValue(iLed,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_led).setDescription(iLed,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_led3).setValue(iLed, "");
														getItem(ITEMS.txtcaracteristica_led).setValue(iLed,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_led).setDescription(iLed,
																sDescripcion);
													}
													insertadoLed = true;
												}
											} else if (sSituacionColumna4.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_led).setValue(iLed, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_led4).setValue(iLed, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_led4).setValue(iLed, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_led).setValue(iLed,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_led).setDescription(iLed,
															sDescripcion);
													insertadoLed = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_led).setValue(iLed, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_led4).setValue(iLed, valores);
														getItem(ITEMS.txtcaracteristica_led).setValue(iLed,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_led).setDescription(iLed,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_led4).setValue(iLed, "");
														getItem(ITEMS.txtcaracteristica_led).setValue(iLed,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_led).setDescription(iLed,
																sDescripcion);
													}
													insertadoLed = true;
												}
											}
										}
										// Led Main - Light
										if (sApartado.equals("07")) {
											if (!(sEstados.contains(sSituacionColumna1))) {
												getItem(ITEMS.txtvalormaestro_ledmain).setValue(iLedmain, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna2))) {
												getItem(ITEMS.txtvalormaestro_ledmain2).setValue(iLedmain, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna3))) {
												getItem(ITEMS.txtvalormaestro_ledmain3).setValue(iLedmain, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna4))) {
												getItem(ITEMS.txtvalormaestro_ledmain4).setValue(iLedmain, "No aplica");
											}
											if (sSituacionColumna1.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_ledmain).setValue(iLedmain, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_ledmain).setValue(iLedmain,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_ledmain).setValue(iLedmain,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_ledmain).setValue(iLedmain,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_ledmain).setDescription(iLedmain,
															sDescripcion);
													insertadoLedmain = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_ledmain).setValue(iLedmain, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_ledmain).setValue(iLedmain,
																valores);
														getItem(ITEMS.txtcaracteristica_ledmain).setValue(iLedmain,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_ledmain)
																.setDescription(iLedmain, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_ledmain).setValue(iLedmain, "");
														getItem(ITEMS.txtcaracteristica_ledmain).setValue(iLedmain,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_ledmain)
																.setDescription(iLedmain, sDescripcion);
													}
													insertadoLedmain = true;
												}
											} else if (sSituacionColumna2.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_ledmain).setValue(iLedmain, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_ledmain2).setValue(iLedmain,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_ledmain2).setValue(iLedmain,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_ledmain).setValue(iLedmain,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_ledmain).setDescription(iLedmain,
															sDescripcion);
													insertadoLedmain = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_ledmain).setValue(iLedmain, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_ledmain2).setValue(iLedmain,
																valores);
														getItem(ITEMS.txtcaracteristica_ledmain).setValue(iLedmain,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_ledmain)
																.setDescription(iLedmain, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_ledmain2).setValue(iLedmain, "");
														getItem(ITEMS.txtcaracteristica_ledmain).setValue(iLedmain,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_ledmain)
																.setDescription(iLedmain, sDescripcion);
													}
													insertadoLedmain = true;
												}
											} else if (sSituacionColumna3.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_ledmain).setValue(iLedmain, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_ledmain3).setValue(iLedmain,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_ledmain3).setValue(iLedmain,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_ledmain).setValue(iLedmain,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_ledmain).setDescription(iLedmain,
															sDescripcion);
													insertadoLedmain = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_ledmain).setValue(iLedmain, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_ledmain3).setValue(iLedmain,
																valores);
														getItem(ITEMS.txtcaracteristica_ledmain).setValue(iLedmain,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_ledmain)
																.setDescription(iLedmain, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_ledmain3).setValue(iLedmain, "");
														getItem(ITEMS.txtcaracteristica_ledmain).setValue(iLedmain,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_ledmain)
																.setDescription(iLedmain, sDescripcion);
													}
													insertadoLedmain = true;
												}
											} else if (sSituacionColumna4.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_ledmain).setValue(iLedmain, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_ledmain4).setValue(iLedmain,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_ledmain4).setValue(iLedmain,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_ledmain).setValue(iLedmain,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_ledmain).setDescription(iLedmain,
															sDescripcion);
													insertadoLedmain = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_ledmain).setValue(iLedmain, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_ledmain4).setValue(iLedmain,
																valores);
														getItem(ITEMS.txtcaracteristica_ledmain).setValue(iLedmain,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_ledmain)
																.setDescription(iLedmain, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_ledmain4).setValue(iLedmain, "");
														getItem(ITEMS.txtcaracteristica_ledmain).setValue(iLedmain,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_ledmain)
																.setDescription(iLedmain, sDescripcion);
													}
													insertadoLedmain = true;
												}
											}
										}
										// Driver
										if (sApartado.equals("08")) {
											if (!(sEstados.contains(sSituacionColumna1))) {
												getItem(ITEMS.txtvalormaestro_driver).setValue(iDriver, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna2))) {
												getItem(ITEMS.txtvalormaestro_driver2).setValue(iDriver, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna3))) {
												getItem(ITEMS.txtvalormaestro_driver3).setValue(iDriver, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna4))) {
												getItem(ITEMS.txtvalormaestro_driver4).setValue(iDriver, "No aplica");
											}
											if (sSituacionColumna1.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_driver).setValue(iDriver, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_driver).setValue(iDriver,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_driver).setValue(iDriver,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_driver).setValue(iDriver,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_driver).setDescription(iDriver,
															sDescripcion);
													insertadoDriver = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_driver).setValue(iDriver, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_driver).setValue(iDriver,
																valores);
														getItem(ITEMS.txtcaracteristica_driver).setValue(iDriver,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_driver).setDescription(iDriver,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_driver).setValue(iDriver, "");
														getItem(ITEMS.txtcaracteristica_driver).setValue(iDriver,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_driver).setDescription(iDriver,
																sDescripcion);
													}
													insertadoDriver = true;
												}
											} else if (sSituacionColumna2.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_driver).setValue(iDriver, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_driver2).setValue(iDriver,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_driver2).setValue(iDriver,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_driver).setValue(iDriver,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_driver).setDescription(iDriver,
															sDescripcion);
													insertadoDriver = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_driver).setValue(iDriver, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_driver2).setValue(iDriver,
																valores);
														getItem(ITEMS.txtcaracteristica_driver).setValue(iDriver,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_driver).setDescription(iDriver,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_driver2).setValue(iDriver, "");
														getItem(ITEMS.txtcaracteristica_driver).setValue(iDriver,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_driver).setDescription(iDriver,
																sDescripcion);
													}
													insertadoDriver = true;
												}
											} else if (sSituacionColumna3.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_driver).setValue(iDriver, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_driver3).setValue(iDriver,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_driver3).setValue(iDriver,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_driver).setValue(iDriver,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_driver).setDescription(iDriver,
															sDescripcion);
													insertadoDriver = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_driver).setValue(iDriver, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_driver3).setValue(iDriver,
																valores);
														getItem(ITEMS.txtcaracteristica_driver).setValue(iDriver,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_driver).setDescription(iDriver,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_driver3).setValue(iDriver, "");
														getItem(ITEMS.txtcaracteristica_driver).setValue(iDriver,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_driver).setDescription(iDriver,
																sDescripcion);
													}
													insertadoDriver = true;
												}
											} else if (sSituacionColumna4.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_driver).setValue(iDriver, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_driver4).setValue(iDriver,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_driver4).setValue(iDriver,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_driver).setValue(iDriver,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_driver).setDescription(iDriver,
															sDescripcion);
													insertadoDriver = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_driver).setValue(iDriver, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_driver4).setValue(iDriver,
																valores);
														getItem(ITEMS.txtcaracteristica_driver).setValue(iDriver,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_driver).setDescription(iDriver,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_driver4).setValue(iDriver, "");
														getItem(ITEMS.txtcaracteristica_driver).setValue(iDriver,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_driver).setDescription(iDriver,
																sDescripcion);
													}
													insertadoDriver = true;
												}
											}
										}
										// Control
										if (sApartado.equals("09")) {
											if (!(sEstados.contains(sSituacionColumna1))) {
												getItem(ITEMS.txtvalormaestro_control).setValue(iControl, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna2))) {
												getItem(ITEMS.txtvalormaestro_control2).setValue(iControl, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna3))) {
												getItem(ITEMS.txtvalormaestro_control3).setValue(iControl, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna4))) {
												getItem(ITEMS.txtvalormaestro_control4).setValue(iControl, "No aplica");
											}
											if (sSituacionColumna1.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_control).setValue(iControl, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_control).setValue(iControl,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_control).setValue(iControl,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_control).setValue(iControl,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_control).setDescription(iControl,
															sDescripcion);
													insertadoControl = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_control).setValue(iControl, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_control).setValue(iControl,
																valores);
														getItem(ITEMS.txtcaracteristica_control).setValue(iControl,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_control)
																.setDescription(iControl, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_control).setValue(iControl, "");
														getItem(ITEMS.txtcaracteristica_control).setValue(iControl,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_control)
																.setDescription(iControl, sDescripcion);
													}
													insertadoControl = true;
												}
											} else if (sSituacionColumna2.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_control).setValue(iControl, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_control2).setValue(iControl,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_control2).setValue(iControl,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_control).setValue(iControl,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_control).setDescription(iControl,
															sDescripcion);
													insertadoControl = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_control).setValue(iControl, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_control2).setValue(iControl,
																valores);
														getItem(ITEMS.txtcaracteristica_control).setValue(iControl,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_control)
																.setDescription(iControl, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_control2).setValue(iControl, "");
														getItem(ITEMS.txtcaracteristica_control).setValue(iControl,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_control)
																.setDescription(iControl, sDescripcion);
													}
													insertadoControl = true;
												}
											} else if (sSituacionColumna3.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_control).setValue(iControl, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_control3).setValue(iControl,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_control3).setValue(iControl,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_control).setValue(iControl,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_control).setDescription(iControl,
															sDescripcion);
													insertadoControl = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_control).setValue(iControl, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_control3).setValue(iControl,
																valores);
														getItem(ITEMS.txtcaracteristica_control).setValue(iControl,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_control)
																.setDescription(iControl, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_control3).setValue(iControl, "");
														getItem(ITEMS.txtcaracteristica_control).setValue(iControl,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_control)
																.setDescription(iControl, sDescripcion);
													}
													insertadoControl = true;
												}
											} else if (sSituacionColumna4.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_control).setValue(iControl, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_control4).setValue(iControl,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_control4).setValue(iControl,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_control).setValue(iControl,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_control).setDescription(iControl,
															sDescripcion);
													insertadoControl = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_control).setValue(iControl, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_control4).setValue(iControl,
																valores);
														getItem(ITEMS.txtcaracteristica_control).setValue(iControl,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_control)
																.setDescription(iControl, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_control4).setValue(iControl, "");
														getItem(ITEMS.txtcaracteristica_control).setValue(iControl,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_control)
																.setDescription(iControl, sDescripcion);
													}
													insertadoControl = true;
												}
											}
										}
										// FAN
										if (sApartado.equals("10")) {
											if (!(sEstados.contains(sSituacionColumna1))) {
												getItem(ITEMS.txtvalormaestro_fan).setValue(iFan, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna2))) {
												getItem(ITEMS.txtvalormaestro_fan2).setValue(iFan, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna3))) {
												getItem(ITEMS.txtvalormaestro_fan3).setValue(iFan, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna4))) {
												getItem(ITEMS.txtvalormaestro_fan4).setValue(iFan, "No aplica");
											}
											if (sSituacionColumna1.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_fan).setValue(iFan, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_fan).setValue(iFan, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_fan).setValue(iFan, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_fan).setValue(iFan,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_fan).setDescription(iFan,
															sDescripcion);
													insertadoControl = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_fan).setValue(iFan, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_fan).setValue(iFan, valores);
														getItem(ITEMS.txtcaracteristica_fan).setValue(iFan,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_fan).setDescription(iFan,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_fan).setValue(iFan, "");
														getItem(ITEMS.txtcaracteristica_fan).setValue(iFan,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_fan).setDescription(iFan,
																sDescripcion);
													}
													insertadoFan = true;
												}
											} else if (sSituacionColumna2.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_fan).setValue(iFan, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_fan2).setValue(iFan, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_fan2).setValue(iFan, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_fan).setValue(iFan,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_fan).setDescription(iFan,
															sDescripcion);
													insertadoControl = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_fan).setValue(iFan, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_fan2).setValue(iFan, valores);
														getItem(ITEMS.txtcaracteristica_fan).setValue(iFan,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_fan).setDescription(iFan,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_fan2).setValue(iFan, "");
														getItem(ITEMS.txtcaracteristica_fan).setValue(iFan,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_fan).setDescription(iFan,
																sDescripcion);
													}
													insertadoFan = true;
												}
											} else if (sSituacionColumna3.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_fan).setValue(iFan, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_fan3).setValue(iFan, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_fan3).setValue(iFan, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_fan).setValue(iFan,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_fan).setDescription(iFan,
															sDescripcion);
													insertadoControl = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_fan).setValue(iFan, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_fan3).setValue(iFan, valores);
														getItem(ITEMS.txtcaracteristica_fan).setValue(iFan,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_fan).setDescription(iFan,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_fan3).setValue(iFan, "");
														getItem(ITEMS.txtcaracteristica_fan).setValue(iFan,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_fan).setDescription(iFan,
																sDescripcion);
													}
													insertadoFan = true;
												}
											} else if (sSituacionColumna4.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_fan).setValue(iFan, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_fan4).setValue(iFan, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_fan4).setValue(iFan, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_fan).setValue(iFan,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_fan).setDescription(iFan,
															sDescripcion);
													insertadoControl = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_fan).setValue(iFan, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_fan4).setValue(iFan, valores);
														getItem(ITEMS.txtcaracteristica_fan).setValue(iFan,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_fan).setDescription(iFan,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_fan4).setValue(iFan, "");
														getItem(ITEMS.txtcaracteristica_fan).setValue(iFan,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_fan).setDescription(iFan,
																sDescripcion);
													}
													insertadoFan = true;
												}
											}
										}
										// DIMENSIONS
										if (sApartado.equals("11")) {
											if (!(sEstados.contains(sSituacionColumna1))) {
												getItem(ITEMS.txtvalormaestro_dimen).setValue(iDimension, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna2))) {
												getItem(ITEMS.txtvalormaestro_dimen2).setValue(iDimension, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna3))) {
												getItem(ITEMS.txtvalormaestro_dimen3).setValue(iDimension, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna4))) {
												getItem(ITEMS.txtvalormaestro_dimen4).setValue(iDimension, "No aplica");
											}
											if (sSituacionColumna1.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_dimen).setValue(iDimension, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_dimen).setValue(iDimension,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_dimen).setValue(iDimension,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_dimen).setValue(iDimension,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_dimen).setDescription(iDimension,
															sDescripcion);
													insertadoDimension = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_dimen).setValue(iDimension, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_dimen).setValue(iDimension,
																valores);
														getItem(ITEMS.txtcaracteristica_dimen).setValue(iDimension,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_dimen)
																.setDescription(iDimension, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_dimen).setValue(iDimension, "");
														getItem(ITEMS.txtcaracteristica_dimen).setValue(iDimension,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_dimen)
																.setDescription(iDimension, sDescripcion);
													}
													insertadoDimension = true;
												}
											} else if (sSituacionColumna2.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_dimen).setValue(iDimension, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_dimen2).setValue(iDimension,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_dimen2).setValue(iDimension,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_dimen).setValue(iDimension,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_dimen).setDescription(iDimension,
															sDescripcion);
													insertadoDimension = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_dimen).setValue(iDimension, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_dimen2).setValue(iDimension,
																valores);
														getItem(ITEMS.txtcaracteristica_dimen).setValue(iDimension,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_dimen)
																.setDescription(iDimension, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_dimen2).setValue(iDimension, "");
														getItem(ITEMS.txtcaracteristica_dimen).setValue(iDimension,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_dimen)
																.setDescription(iDimension, sDescripcion);
													}
													insertadoDimension = true;
												}
											} else if (sSituacionColumna3.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_dimen).setValue(iDimension, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_dimen3).setValue(iDimension,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_dimen3).setValue(iDimension,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_dimen).setValue(iDimension,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_dimen).setDescription(iDimension,
															sDescripcion);
													insertadoDimension = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_dimen).setValue(iDimension, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_dimen3).setValue(iDimension,
																valores);
														getItem(ITEMS.txtcaracteristica_dimen).setValue(iDimension,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_dimen)
																.setDescription(iDimension, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_dimen3).setValue(iDimension, "");
														getItem(ITEMS.txtcaracteristica_dimen).setValue(iDimension,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_dimen)
																.setDescription(iDimension, sDescripcion);
													}
													insertadoDimension = true;
												}
											} else if (sSituacionColumna4.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_dimen).setValue(iDimension, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_dimen4).setValue(iDimension,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_dimen4).setValue(iDimension,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_dimen).setValue(iDimension,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_dimen).setDescription(iDimension,
															sDescripcion);
													insertadoDimension = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_dimen).setValue(iDimension, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_dimen4).setValue(iDimension,
																valores);
														getItem(ITEMS.txtcaracteristica_dimen).setValue(iDimension,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_dimen)
																.setDescription(iDimension, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_dimen4).setValue(iDimension, "");
														getItem(ITEMS.txtcaracteristica_dimen).setValue(iDimension,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_dimen)
																.setDescription(iDimension, sDescripcion);
													}
													insertadoDimension = true;
												}
											}
										}
										// Remote
										if (sApartado.equals("12")) {
											if (!(sEstados.contains(sSituacionColumna1))) {
												getItem(ITEMS.txtvalormaestro_remote).setValue(iRemote, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna2))) {
												getItem(ITEMS.txtvalormaestro_remote2).setValue(iRemote, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna3))) {
												getItem(ITEMS.txtvalormaestro_remote3).setValue(iRemote, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna4))) {
												getItem(ITEMS.txtvalormaestro_remote4).setValue(iRemote, "No aplica");
											}
											if (sSituacionColumna1.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_remote).setValue(iRemote, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_remote).setValue(iRemote,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_remote).setValue(iRemote,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_remote).setValue(iRemote,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_remote).setDescription(iRemote,
															sDescripcion);
													insertadoRemote = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_remote).setValue(iRemote, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_remote).setValue(iRemote,
																valores);
														getItem(ITEMS.txtcaracteristica_remote).setValue(iRemote,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_remote).setDescription(iRemote,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_remote).setValue(iRemote, "");
														getItem(ITEMS.txtcaracteristica_remote).setValue(iRemote,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_remote).setDescription(iRemote,
																sDescripcion);
													}
													insertadoRemote = true;
												}
											} else if (sSituacionColumna2.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_remote).setValue(iRemote, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_remote2).setValue(iRemote,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_remote2).setValue(iRemote,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_remote).setValue(iRemote,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_remote).setDescription(iRemote,
															sDescripcion);
													insertadoRemote = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_remote).setValue(iRemote, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_remote2).setValue(iRemote,
																valores);
														getItem(ITEMS.txtcaracteristica_remote).setValue(iRemote,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_remote).setDescription(iRemote,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_remote2).setValue(iRemote, "");
														getItem(ITEMS.txtcaracteristica_remote).setValue(iRemote,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_remote).setDescription(iRemote,
																sDescripcion);
													}
													insertadoRemote = true;
												}
											} else if (sSituacionColumna3.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_remote).setValue(iRemote, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_remote3).setValue(iRemote,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_remote3).setValue(iRemote,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_remote).setValue(iRemote,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_remote).setDescription(iRemote,
															sDescripcion);
													insertadoRemote = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_remote).setValue(iRemote, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_remote3).setValue(iRemote,
																valores);
														getItem(ITEMS.txtcaracteristica_remote).setValue(iRemote,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_remote).setDescription(iRemote,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_remote3).setValue(iRemote, "");
														getItem(ITEMS.txtcaracteristica_remote).setValue(iRemote,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_remote).setDescription(iRemote,
																sDescripcion);
													}
													insertadoRemote = true;
												}
											} else if (sSituacionColumna4.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_remote).setValue(iRemote, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_remote4).setValue(iRemote,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_remote4).setValue(iRemote,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_remote).setValue(iRemote,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_remote).setDescription(iRemote,
															sDescripcion);
													insertadoRemote = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_remote).setValue(iRemote, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_remote4).setValue(iRemote,
																valores);
														getItem(ITEMS.txtcaracteristica_remote).setValue(iRemote,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_remote).setDescription(iRemote,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_remote4).setValue(iRemote, "");
														getItem(ITEMS.txtcaracteristica_remote).setValue(iRemote,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_remote).setDescription(iRemote,
																sDescripcion);
													}
													insertadoRemote = true;
												}
											}
										}
										// Test
										if (sApartado.equals("13")) {
											if (!(sEstados.contains(sSituacionColumna1))) {
												getItem(ITEMS.txtvalormaestro_test).setValue(iTest, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna2))) {
												getItem(ITEMS.txtvalormaestro_test2).setValue(iTest, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna3))) {
												getItem(ITEMS.txtvalormaestro_test3).setValue(iTest, "No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna4))) {
												getItem(ITEMS.txtvalormaestro_test4).setValue(iTest, "No aplica");
											}
											if (sSituacionColumna1.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_test).setValue(iTest, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_test).setValue(iTest, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_test).setValue(iTest, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_test).setValue(iTest,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_test).setDescription(iTest,
															sDescripcion);
													insertadoTest = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_test).setValue(iTest, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_test).setValue(iTest, valores);
														getItem(ITEMS.txtcaracteristica_test).setValue(iTest,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_test).setDescription(iTest,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_test).setValue(iTest, "");
														getItem(ITEMS.txtcaracteristica_test).setValue(iTest,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_test).setDescription(iTest,
																sDescripcion);
													}
													insertadoTest = true;
												}
											} else if (sSituacionColumna2.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_test).setValue(iTest, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_test2).setValue(iTest, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_test2).setValue(iTest, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_test).setValue(iTest,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_test).setDescription(iTest,
															sDescripcion);
													insertadoTest = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_test).setValue(iTest, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_test2).setValue(iTest, valores);
														getItem(ITEMS.txtcaracteristica_test).setValue(iTest,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_test).setDescription(iTest,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_test2).setValue(iTest, "");
														getItem(ITEMS.txtcaracteristica_test).setValue(iTest,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_test).setDescription(iTest,
																sDescripcion);
													}
													insertadoTest = true;
												}
											} else if (sSituacionColumna3.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_test).setValue(iTest, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_test3).setValue(iTest, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_test3).setValue(iTest, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_test).setValue(iTest,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_test).setDescription(iTest,
															sDescripcion);
													insertadoTest = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_test).setValue(iTest, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_test3).setValue(iTest, valores);
														getItem(ITEMS.txtcaracteristica_test).setValue(iTest,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_test).setDescription(iTest,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_test3).setValue(iTest, "");
														getItem(ITEMS.txtcaracteristica_test).setValue(iTest,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_test).setDescription(iTest,
																sDescripcion);
													}
													insertadoTest = true;
												}
											} else if (sSituacionColumna4.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_test).setValue(iTest, nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_test4).setValue(iTest, sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_test4).setValue(iTest, sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_test).setValue(iTest,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_test).setDescription(iTest,
															sDescripcion);
													insertadoTest = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_test).setValue(iTest, nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_test4).setValue(iTest, valores);
														getItem(ITEMS.txtcaracteristica_test).setValue(iTest,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_test).setDescription(iTest,
																sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_test4).setValue(iTest, "");
														getItem(ITEMS.txtcaracteristica_test).setValue(iTest,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_test).setDescription(iTest,
																sDescripcion);
													}
													insertadoTest = true;
												}
											}
										}
										// Datos de chequeo
										if (sApartado.equals("14")) {
											if (!(sEstados.contains(sSituacionColumna1))) {
												getItem(ITEMS.txtvalormaestro_dat_chec).setValue(iDatosChequeo,
														"No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna2))) {
												getItem(ITEMS.txtvalormaestro_dat_chec2).setValue(iDatosChequeo,
														"No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna3))) {
												getItem(ITEMS.txtvalormaestro_dat_chec3).setValue(iDatosChequeo,
														"No aplica");
											}
											if (!(sEstados.contains(sSituacionColumna4))) {
												getItem(ITEMS.txtvalormaestro_dat_chec4).setValue(iDatosChequeo,
														"No aplica");
											}
											if (sSituacionColumna1.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_dat_chec).setValue(iDatosChequeo,
																nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_dat_chec).setValue(iDatosChequeo,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_dat_chec).setValue(iDatosChequeo,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_dat_che).setValue(iDatosChequeo,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_dat_che)
															.setDescription(iDatosChequeo, sDescripcion);
													insertadoDatosChequeo = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_dat_chec).setValue(iDatosChequeo,
																nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_dat_chec).setValue(iDatosChequeo,
																valores);
														getItem(ITEMS.txtcaracteristica_dat_che).setValue(iDatosChequeo,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_dat_che)
																.setDescription(iDatosChequeo, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_dat_chec).setValue(iDatosChequeo,
																"");
														getItem(ITEMS.txtcaracteristica_dat_che).setValue(iDatosChequeo,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_dat_che)
																.setDescription(iDatosChequeo, sDescripcion);
													}
													insertadoDatosChequeo = true;
												}
											} else if (sSituacionColumna2.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_dat_chec).setValue(iDatosChequeo,
																nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_dat_chec2).setValue(iDatosChequeo,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_dat_chec2).setValue(iDatosChequeo,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_dat_che).setValue(iDatosChequeo,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_dat_che)
															.setDescription(iDatosChequeo, sDescripcion);
													insertadoDatosChequeo = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_dat_chec).setValue(iDatosChequeo,
																nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_dat_chec2).setValue(iDatosChequeo,
																valores);
														getItem(ITEMS.txtcaracteristica_dat_che).setValue(iDatosChequeo,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_dat_che)
																.setDescription(iDatosChequeo, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_dat_chec2).setValue(iDatosChequeo,
																"");
														getItem(ITEMS.txtcaracteristica_dat_che).setValue(iDatosChequeo,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_dat_che)
																.setDescription(iDatosChequeo, sDescripcion);
													}
													insertadoDatosChequeo = true;
												}
											} else if (sSituacionColumna3.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_dat_chec).setValue(iDatosChequeo,
																nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_dat_chec3).setValue(iDatosChequeo,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_dat_chec3).setValue(iDatosChequeo,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_dat_che).setValue(iDatosChequeo,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_dat_che)
															.setDescription(iDatosChequeo, sDescripcion);
													insertadoDatosChequeo = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_dat_chec).setValue(iDatosChequeo,
																nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_dat_chec3).setValue(iDatosChequeo,
																valores);
														getItem(ITEMS.txtcaracteristica_dat_che).setValue(iDatosChequeo,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_dat_che)
																.setDescription(iDatosChequeo, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_dat_chec3).setValue(iDatosChequeo,
																"");
														getItem(ITEMS.txtcaracteristica_dat_che).setValue(iDatosChequeo,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_dat_che)
																.setDescription(iDatosChequeo, sDescripcion);
													}
													insertadoDatosChequeo = true;
												}
											} else if (sSituacionColumna4.equals(sSituacionCarac)) {
												if (sTipo.equals("0")) {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_dat_chec).setValue(iDatosChequeo,
																nombres);
													} // han insertado
													if (valores.equals("0")) {
														getItem(ITEMS.txtvalormaestro_dat_chec4).setValue(iDatosChequeo,
																sNombre2);
													} else {
														getItem(ITEMS.txtvalormaestro_dat_chec4).setValue(iDatosChequeo,
																sNombre1);
													}
													getItem(ITEMS.txtcaracteristica_dat_che).setValue(iDatosChequeo,
															sCaracteristicas);
													getItem(ITEMS.txtcaracteristica_dat_che)
															.setDescription(iDatosChequeo, sDescripcion);
													insertadoDatosChequeo = true;
												} else {
													if (!(nombres == null || nombres.equals(""))) {
														getItem(ITEMS.txtnombres_dat_chec).setValue(iDatosChequeo,
																nombres);
													}
													if (!(valores == null || valores.equals(""))) {

														getItem(ITEMS.txtvalormaestro_dat_chec4).setValue(iDatosChequeo,
																valores);
														getItem(ITEMS.txtcaracteristica_dat_che).setValue(iDatosChequeo,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_dat_che)
																.setDescription(iDatosChequeo, sDescripcion);
													} else {
														getItem(ITEMS.txtvalormaestro_dat_chec4).setValue(iDatosChequeo,
																"");
														getItem(ITEMS.txtcaracteristica_dat_che).setValue(iDatosChequeo,
																sCaracteristicas);
														getItem(ITEMS.txtcaracteristica_dat_che)
																.setDescription(iDatosChequeo, sDescripcion);
													}
													insertadoDatosChequeo = true;
												}
											}
										}
									}
								}
								if (insertadoCertificado == true)
									iCertificados++;
								if (insertadoProductInf == true)
									iProductInf++;
								if (insertadoGeneral == true)
									iGeneral++;
								if (insertadoComponentes == true)
									iComponentes++;
								if (insertadoControl == true)
									iControl++;
								if (insertadoDatosChequeo == true)
									iDatosChequeo++;
								if (insertadoDimension == true)
									iDimension++;
								if (insertadoDriver == true)
									iDriver++;
								if (insertadoFan == true)
									iFan++;
								if (insertadoLed == true)
									iLed++;
								if (insertadoLedmain == true)
									iLedmain++;
								if (insertadoPack == true)
									iPack++;
								if (insertadoRemote == true)
									iRemote++;
								if (insertadoTest == true)
									iTest++;
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
				}
			}
			oRes3.close();

		} catch (OTException ot) {
			ot.printStackTrace();
			oRes3.close();
			try {
				throw new PMException(session, ot);
			} catch (PMException e) {
				e.printStackTrace();
			}
		}
		iPanel.setAllowInsert(false);
		iPanel2.setAllowInsert(false);
		iPanel3.setAllowInsert(false);
		iPanel4.setAllowInsert(false);
		iPanel5.setAllowInsert(false);
		iPanel6.setAllowInsert(false);
		iPanel7.setAllowInsert(false);
		iPanel8.setAllowInsert(false);
		iPanel9.setAllowInsert(false);
		iPanel10.setAllowInsert(false);
		iPanel11.setAllowInsert(false);
		iPanel12.setAllowInsert(false);
		iPanel13.setAllowInsert(false);
		iPanel14.setAllowInsert(false);
	}

	private void rellenarRepuestosLink(String sEmpresa, String sArticulo_padre, String sSituacion, int iColumna)
			throws DAException {
		
		String sArticulo = "";
		String sFamilia = "";
		String sDescripcionArt = "";
		String sCaracteristica = "";
		String sCaracteristicasInsertadas = "";

		int iRepuesto = 1;
		
		try {
			// Buscamos los repuestos del articulo padre marcados como link dsp.
			String sql = "select rep.xarticulo_id, art.xfamilia_produc,art.xdescripcion from "
					+ connSdic.translateTable("adv_repuesto_art") + " rep inner join "
					+ connSdic.translateTable("pl_articulos")
					+ " art on rep.xarticulo_id=art.xarticulo_id and rep.xempresa_id=art.xempresa_id"
					+ " where rep.xarticulo_id_padre='" + sArticulo_padre + "' and rep.xempresa_id='" + sEmpresa
					+ "' and rep.xlink_dsp=-1";
			try (DAResultSet oResLink = session.getConnectionData().openSQL(sql)) {
				while (oResLink.moveNext()) {
					sCaracteristicasInsertadas = "";
					sArticulo = oResLink.getString("xarticulo_id");
					sFamilia = oResLink.getString("xfamilia_produc");
					sDescripcionArt = oResLink.getString("xdescripcion");
					// Buscamos las carecteristicas asociadas a la familia del repuesto.
					boolean caracteristicaInsertada=false;
					int iContadorGenerico = 0;
					sql = "select xcaracteristica_id from " + connSdic.translateTable("s_dspc_fam") + " where xfamilia_id='"
							+ sFamilia + "' order by xorden";
					try (DAResultSet oResLink2 = session.getConnectionData().openSQL(sql)) {
						while (oResLink2.moveNext()) {
							sCaracteristica = oResLink2.getString("xcaracteristica_id");
							int iIdioma = session.getLanguageCode();
							if (sCaracteristicasInsertadas.contains(sCaracteristica)) {
								continue;
							}
							// Bajamos los datos de cada caracteristica del repuesto
							sql = "select car.xdescripcion,car.xnombre1, car.xnombre2,art.xsituacion_dsp situacionArt,gen.xfamilia_produc,gen.xtecnologia"
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
									+ " ELSE ' / ' + cast(art.xvalortexto6 as varchar) END " + "when 3 then "
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
									+ "ELSE ' / ' + cast(art.xvalorint6 as varchar) END when 4 then "
									+ "CASE WHEN cast(art.xvalordecimal1 as varchar) IS NULL OR cast(art.xvalordecimal1 as varchar)= '' "
									+ "THEN '' ELSE cast(art.xvalordecimal1 as varchar)END +"
									+ "CASE WHEN cast(art.xvalordecimal2 as varchar) IS NULL OR cast(art.xvalordecimal2 as varchar)= ''"
									+ " THEN '' ELSE ' / ' + cast(art.xvalordecimal2 as varchar)END +"
									+ "CASE WHEN cast(art.xvalordecimal3 as varchar)IS NULL OR cast(art.xvalordecimal3 as varchar)= ''"
									+ " THEN '' ELSE ' / ' + cast(art.xvalordecimal3 as varchar) END +"
									+ "CASE WHEN cast(art.xvalordecimal4 as varchar)IS NULL OR cast(art.xvalordecimal4 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalordecimal4 as varchar) END +"
									+ "CASE WHEN cast(art.xvalordecimal5 as varchar)IS NULL OR cast(art.xvalordecimal5 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalordecimal5 as varchar) END +"
									+ "CASE WHEN cast(art.xvalordecimal6 as varchar)IS NULL OR cast(art.xvalordecimal6 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalordecimal6 as varchar) END end as valores"
									+ ", CASE WHEN cast(car.xnombre1 as varchar) IS NULL OR cast(car.xnombre1  as varchar)= '' THEN '' ELSE cast(car.xnombre1  as varchar)END +"
									+ " CASE WHEN cast(car.xnombre2 as varchar) IS NULL OR cast(car.xnombre2  as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre2  as varchar)END +"
									+ " CASE WHEN cast(car.xnombre3  as varchar)IS NULL OR cast(car.xnombre3 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre3 as varchar) END +"
									+ " CASE WHEN cast(car.xnombre4 as varchar)IS NULL OR cast(car.xnombre4  as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre4  as varchar) END +"
									+ " CASE WHEN cast(car.xnombre5 as varchar)IS NULL OR cast(car.xnombre5 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre5 as varchar) END +"
									+ " CASE WHEN cast(car.xnombre6 as varchar)IS NULL OR cast(car.xnombre6 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre6 as varchar) END as nombres"
									+ " from " + connSdic.translateTable("s_art_carac") + " art " + " inner join "
									+ connSdic.translateTable("s_caracteristicas")
									+ " car on art.xcaracteristica_id=car.xcaracteristica_id " + " inner join "
									+ connSdic.translateTable("pl_articulos")
									+ " gen on gen.xarticulo_id = art.xarticulo_id and gen.xempresa_id = art.xempresa_id"
									+ " inner join " + connSdic.translateTable("s_carac_fam")
									+ " fam on fam.xempresa_id = art.xempresa_id and fam.xcaracteristica_id = car.xcaracteristica_id"
									+ " left outer join " + connSdic.translateTable("sul_art_listas")
									+ " lista on lista.xlista_id=car.xlista1 and art.xvalorlista1=lista.xlinea_id "
									+ " left outer join imp.sul_art_listasmlg mlg on mlg.xlista_id=lista.xlista_id and mlg.xlinea_id=lista.xlinea_id"
									+ " where  art.xempresa_id='" + sEmpresa + "' and  art.xarticulo_id='" + sArticulo
									+ "' "
									+ " and gen.xfamilia_produc=fam.xfamilia_id and gen.xtecnologia = fam.xssfamilia_id"
									+ " and car.xbaja=0 " + " and car.xcaracteristica_id='" + sCaracteristica + "'"
									+ " and art.xsituacion_dsp='" + sSituacion + "'";
							try (DAResultSet oResLink3 = session.getConnectionData().openSQL(sql)) {
	
								if (oResLink3.moveNext()) {
									caracteristicaInsertada=true;
										getContainer(CONTAINERS.valueOf("collap_link" + iRepuesto))
										.setCaption("Repuesto:" + sArticulo + " - " + sDescripcionArt);
									
									String sSituacionCarac = oResLink3.getString("situacionArt");
									String sNombre1 = oResLink3.getString("xnombre1");
									String sNombre2 = oResLink3.getString("xnombre2");
	
									String valores = oResLink3.getString("valores");
									String nombres = oResLink3.getString("nombres");
									String sDescripcion = oResLink3.getString("xdescripcion");
									String sCaracteristicas = oResLink3.getString("xcaracteristica_id");
									String sTipo = oResLink3.getString("xtipo_valor");
									String sApartado = oResLink3.getString("xapartado_id");
	
									String sNombreCol = "";
									String sNombreCarac = "";
	
									switch (iColumna) {
									case 1:
										sNombreCol = situacionColumna1;
										break;
									case 2:
										sNombreCol = situacionColumna2;
										break;
									case 3:
										sNombreCol = situacionColumna3;
										break;
									case 4:
										sNombreCol = situacionColumna4;
										break;
	
									default:
										break;
									}
	
									getView(VIEWS.valueOf("txtcaracteristica_link" + iRepuesto))
											.setCaption("Caracteristica");
									getView(VIEWS.valueOf("txtvalormaestro_link" + iRepuesto + iColumna))
											.setCaption(sNombreCol);
	
									if (sTipo.equals("0")) {
										if (!(nombres == null || nombres.equals(""))) {
											getItem(ITEMS.valueOf("txtnombres_link" + iRepuesto))
													.setValue(iContadorGenerico, nombres);
										}
										if (valores.equals("0")) {
											getItem(ITEMS.valueOf("txtvalormaestro_link" + iRepuesto + iColumna))
													.setValue(iContadorGenerico, sNombre2);
										} else {
											getItem(ITEMS.valueOf("txtvalormaestro_link" + iRepuesto + iColumna))
													.setValue(iContadorGenerico, sNombre1);
										}
										getItem(ITEMS.valueOf("txtcaracteristica_link" + iRepuesto))
												.setValue(iContadorGenerico, sCaracteristicas);
										getItem(ITEMS.valueOf("txtcaracteristica_link" + iRepuesto))
												.setDescription(iContadorGenerico, sDescripcion);
									} else {
										if (!(nombres == null || nombres.equals(""))) {
											getItem(ITEMS.valueOf("txtnombres_link" + iRepuesto))
													.setValue(iContadorGenerico, nombres);
										}
										if (!(valores == null || valores.equals(""))) {
	
											getItem(ITEMS.valueOf("txtvalormaestro_link" + iRepuesto + iColumna))
													.setValue(iContadorGenerico, valores);
	
										} else {
											getItem(ITEMS.valueOf("txtvalormaestro_link" + iRepuesto + iColumna))
													.setValue(iContadorGenerico, "");
	
										}
										getItem(ITEMS.valueOf("txtcaracteristica_link" + iRepuesto))
												.setValue(iContadorGenerico, sCaracteristicas);
										getItem(ITEMS.valueOf("txtcaracteristica_link" + iRepuesto))
												.setDescription(iContadorGenerico, sDescripcion);
									}
									iContadorGenerico++;
									sCaracteristicasInsertadas += "," + sCaracteristicas;
	
								}
							} catch (Exception ot) {
								ot.printStackTrace();
								oResLink3.close();
								try {
									throw new PMException(session, ot);
								} catch (PMException e) {
									e.printStackTrace();
								}
							}
	
						}
					} catch (OTException ot) {
						ot.printStackTrace();
						oResLink2.close();
						try {
							throw new PMException(session, ot);
						} catch (PMException e) {
							e.printStackTrace();
						}
					}
	
					iRepuesto++;
				}
			} catch (Exception ot) {
				ot.printStackTrace();
				oResLink.close();
				try {
					throw new PMException(session, ot);
				} catch (PMException e) {
					e.printStackTrace();
				}
			}
	
			
			//buscamos en el escandallo 
			sCaracteristicasInsertadas="";
			sql = "select des.xcomponente_id, art.xfamilia_produc,art.xdescripcion from imp.s_art_desglose des "
					+ "inner join imp.pl_articulos art on des.xcomponente_id=art.xarticulo_id and des.xempresa_id=art.xempresa_id "
					+ "where des.xarticulo_id='"+sArticulo_padre+"' and des.xempresa_id='"+sEmpresa+"' and des.xlink_dsp=-1";
			try (DAResultSet oResLink = session.getConnectionData().openSQL(sql)) {
				while (oResLink.moveNext()) {
					sArticulo = oResLink.getString("xcomponente_id");
					sFamilia = oResLink.getString("xfamilia_produc");
					sDescripcionArt = oResLink.getString("xdescripcion");
					boolean caracteristicaInsertada=false;
					// Buscamos las carecteristicas asociadas a la familia del repuesto.
	
					int iContadorGenerico = 0;
					sql = "select xcaracteristica_id from " + connSdic.translateTable("s_dspc_fam") + " where xfamilia_id='"
							+ sFamilia + "'";
					try (DAResultSet oResLink2 = session.getConnectionData().openSQL(sql)) {
						while (oResLink2.moveNext()) {
							sCaracteristica = oResLink2.getString("xcaracteristica_id");
							int iIdioma = session.getLanguageCode();
							if (sCaracteristicasInsertadas.contains(sCaracteristica)) {
								continue;
							}
							// Bajamos los datos de cada caracteristica del repuesto
							sql = "select car.xdescripcion,car.xnombre1, car.xnombre2,art.xsituacion_dsp situacionArt,gen.xfamilia_produc,gen.xtecnologia"
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
									+ " ELSE ' / ' + cast(art.xvalortexto6 as varchar) END " + "when 3 then "
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
									+ "ELSE ' / ' + cast(art.xvalorint6 as varchar) END when 4 then "
									+ "CASE WHEN cast(art.xvalordecimal1 as varchar) IS NULL OR cast(art.xvalordecimal1 as varchar)= '' "
									+ "THEN '' ELSE cast(art.xvalordecimal1 as varchar)END +"
									+ "CASE WHEN cast(art.xvalordecimal2 as varchar) IS NULL OR cast(art.xvalordecimal2 as varchar)= ''"
									+ " THEN '' ELSE ' / ' + cast(art.xvalordecimal2 as varchar)END +"
									+ "CASE WHEN cast(art.xvalordecimal3 as varchar)IS NULL OR cast(art.xvalordecimal3 as varchar)= ''"
									+ " THEN '' ELSE ' / ' + cast(art.xvalordecimal3 as varchar) END +"
									+ "CASE WHEN cast(art.xvalordecimal4 as varchar)IS NULL OR cast(art.xvalordecimal4 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalordecimal4 as varchar) END +"
									+ "CASE WHEN cast(art.xvalordecimal5 as varchar)IS NULL OR cast(art.xvalordecimal5 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalordecimal5 as varchar) END +"
									+ "CASE WHEN cast(art.xvalordecimal6 as varchar)IS NULL OR cast(art.xvalordecimal6 as varchar)= '' THEN ''"
									+ " ELSE ' / ' + cast(art.xvalordecimal6 as varchar) END end as valores"
									+ ", CASE WHEN cast(car.xnombre1 as varchar) IS NULL OR cast(car.xnombre1  as varchar)= '' THEN '' ELSE cast(car.xnombre1  as varchar)END +"
									+ " CASE WHEN cast(car.xnombre2 as varchar) IS NULL OR cast(car.xnombre2  as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre2  as varchar)END +"
									+ " CASE WHEN cast(car.xnombre3  as varchar)IS NULL OR cast(car.xnombre3 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre3 as varchar) END +"
									+ " CASE WHEN cast(car.xnombre4 as varchar)IS NULL OR cast(car.xnombre4  as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre4  as varchar) END +"
									+ " CASE WHEN cast(car.xnombre5 as varchar)IS NULL OR cast(car.xnombre5 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre5 as varchar) END +"
									+ " CASE WHEN cast(car.xnombre6 as varchar)IS NULL OR cast(car.xnombre6 as varchar)= '' THEN '' ELSE ' / ' + cast(car.xnombre6 as varchar) END as nombres"
									+ " from " + connSdic.translateTable("s_art_carac") + " art " + " inner join "
									+ connSdic.translateTable("s_caracteristicas")
									+ " car on art.xcaracteristica_id=car.xcaracteristica_id " + " inner join "
									+ connSdic.translateTable("pl_articulos")
									+ " gen on gen.xarticulo_id = art.xarticulo_id and gen.xempresa_id = art.xempresa_id"
									+ " inner join " + connSdic.translateTable("s_carac_fam")
									+ " fam on fam.xempresa_id = art.xempresa_id and fam.xcaracteristica_id = car.xcaracteristica_id"
									+ " left outer join " + connSdic.translateTable("sul_art_listas")
									+ " lista on lista.xlista_id=car.xlista1 and art.xvalorlista1=lista.xlinea_id "
									+ " left outer join imp.sul_art_listasmlg mlg on mlg.xlista_id=lista.xlista_id and mlg.xlinea_id=lista.xlinea_id"
									+ " where  art.xempresa_id='" + sEmpresa + "' and  art.xarticulo_id='" + sArticulo
									+ "' "
									+ " and gen.xfamilia_produc=fam.xfamilia_id and gen.xtecnologia = fam.xssfamilia_id"
									+ " and car.xbaja=0 " + " and car.xcaracteristica_id='" + sCaracteristica + "'"
									+ " and art.xsituacion_dsp='" + sSituacion + "'";
							try (DAResultSet oResLink3 = session.getConnectionData().openSQL(sql)) {
	
								if (oResLink3.moveNext()) {
									
									getContainer(CONTAINERS.valueOf("collap_link" + iRepuesto))
									.setCaption("Repuesto:" + sArticulo + " - " + sDescripcionArt);
									
									String sSituacionCarac = oResLink3.getString("situacionArt");
									String sNombre1 = oResLink3.getString("xnombre1");
									String sNombre2 = oResLink3.getString("xnombre2");
	
									String valores = oResLink3.getString("valores");
									String nombres = oResLink3.getString("nombres");
									String sDescripcion = oResLink3.getString("xdescripcion");
									String sCaracteristicas = oResLink3.getString("xcaracteristica_id");
									String sTipo = oResLink3.getString("xtipo_valor");
									String sApartado = oResLink3.getString("xapartado_id");
	
									String sNombreCol = "";
									String sNombreCarac = "";
	
									switch (iColumna) {
									case 1:
										sNombreCol = situacionColumna1;
										break;
									case 2:
										sNombreCol = situacionColumna2;
										break;
									case 3:
										sNombreCol = situacionColumna3;
										break;
									case 4:
										sNombreCol = situacionColumna4;
										break;
	
									default:
										break;
									}
	
									getView(VIEWS.valueOf("txtcaracteristica_link" + iRepuesto))
											.setCaption("Caracteristica");
									getView(VIEWS.valueOf("txtvalormaestro_link" + iRepuesto + iColumna))
											.setCaption(sNombreCol);
	
									if (sTipo.equals("0")) {
										if (!(nombres == null || nombres.equals(""))) {
											getItem(ITEMS.valueOf("txtnombres_link" + iRepuesto))
													.setValue(iContadorGenerico, nombres);
										}
										if (valores.equals("0")) {
											getItem(ITEMS.valueOf("txtvalormaestro_link" + iRepuesto + iColumna))
													.setValue(iContadorGenerico, sNombre2);
										} else {
											getItem(ITEMS.valueOf("txtvalormaestro_link" + iRepuesto + iColumna))
													.setValue(iContadorGenerico, sNombre1);
										}
										getItem(ITEMS.valueOf("txtcaracteristica_link" + iRepuesto))
												.setValue(iContadorGenerico, sCaracteristicas);
										getItem(ITEMS.valueOf("txtcaracteristica_link" + iRepuesto))
												.setDescription(iContadorGenerico, sDescripcion);
									} else {
										if (!(nombres == null || nombres.equals(""))) {
											getItem(ITEMS.valueOf("txtnombres_link" + iRepuesto))
													.setValue(iContadorGenerico, nombres);
										}
										if (!(valores == null || valores.equals(""))) {
	
											getItem(ITEMS.valueOf("txtvalormaestro_link" + iRepuesto + iColumna))
													.setValue(iContadorGenerico, valores);
	
										} else {
											getItem(ITEMS.valueOf("txtvalormaestro_link" + iRepuesto + iColumna))
													.setValue(iContadorGenerico, "");
	
										}
										getItem(ITEMS.valueOf("txtcaracteristica_link" + iRepuesto))
												.setValue(iContadorGenerico, sCaracteristicas);
										getItem(ITEMS.valueOf("txtcaracteristica_link" + iRepuesto))
												.setDescription(iContadorGenerico, sDescripcion);
									}
									iContadorGenerico++;
									sCaracteristicasInsertadas += "," + sCaracteristicas;
	
								}
							} catch (Exception ot) {
								ot.printStackTrace();
								oResLink3.close();
								try {
									throw new PMException(session, ot);
								} catch (PMException e) {
									e.printStackTrace();
								}
							}
	
						}
					} catch (OTException ot) {
						ot.printStackTrace();
						oResLink2.close();
						try {
							throw new PMException(session, ot);
						} catch (PMException e) {
							e.printStackTrace();
						}
					}
					iRepuesto++;

				}
			} catch (Exception ot) {
				ot.printStackTrace();
				oResLink.close();
				try {
					throw new PMException(session, ot);
				} catch (PMException e) {
					e.printStackTrace();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

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

	private void renombrarColumnas() {
		// Columna 1
		ApartadoEnum[] apartados = ApartadoEnum.values();
		for (int i = 0; i < apartados.length; i++) {
			getView(VIEWS.valueOf("txtvalormaestro_" + apartados[i].nombreValor)).setCaption(situacionColumna1);
			getView(VIEWS.valueOf("txtvalormaestro_" + apartados[i].nombreValor + "2")).setCaption(situacionColumna2);
			getView(VIEWS.valueOf("txtvalormaestro_" + apartados[i].nombreValor + "3")).setCaption(situacionColumna3);
			getView(VIEWS.valueOf("txtvalormaestro_" + apartados[i].nombreValor + "4")).setCaption(situacionColumna4);
		}

	}

	private void rellenarCombosSituacion(String sArticulo) throws DAException {
		FMCombo fmCombo = (FMCombo) getView(VIEWS.txtcolumnaestado1);
		fmCombo.setSystemList(null);
		fmCombo.clearItems();
		FMCombo fmCombo2 = (FMCombo) getView(VIEWS.txtcolumnaestado2);
		fmCombo2.setSystemList(null);
		fmCombo2.clearItems();
		FMCombo fmCombo3 = (FMCombo) getView(VIEWS.txtcolumnaestado3);
		fmCombo3.setSystemList(null);
		fmCombo3.clearItems();
		FMCombo fmCombo4 = (FMCombo) getView(VIEWS.txtcolumnaestado4);
		fmCombo4.setSystemList(null);
		fmCombo4.clearItems();

		// Vaciamos los combos y solo mostramos el primero por defecto
		getView(VIEWS.txtcolumnaestado1).setVisible(false);
		getView(VIEWS.txtcolumnaestado2).setVisible(false);
		getView(VIEWS.txtcolumnaestado3).setVisible(false);
		getView(VIEWS.txtcolumnaestado4).setVisible(false);

		String sqlCombo = "select distinct xsituacion_dsp from " + connSdic.translateTable("s_art_carac")
				+ " where xarticulo_id='" + sArticulo + "'";
		oRes = connData.openSQL(sqlCombo);
		int iEstados = 0;
		// En función del número de estados encontrados hacemos visible los combos
		while (oRes.moveNext()) {
			if (iEstados == 1) {
				getView(VIEWS.txtcolumnaestado1).setVisible(true);
			} else if (iEstados == 2) {
				getView(VIEWS.txtcolumnaestado2).setVisible(true);
			} else if (iEstados == 3) {
				getView(VIEWS.txtcolumnaestado3).setVisible(true);
			} else if (iEstados == 4) {
				getView(VIEWS.txtcolumnaestado4).setVisible(true);
			}			

			iEstados++;
		}
		oRes.close();
		String Columna1 = "";
		String Columna2 = "";
		String Columna3 = "";
		String Columna4 = "";
		if (!(situacionColumna1 == null || situacionColumna1.equals(""))) {
			String datos[] = situacionColumna1.split("#");
			Columna1 = datos[0];
		}
		if (!(situacionColumna2 == null || situacionColumna2.equals(""))) {
			String datos[] = situacionColumna2.split("#");
			Columna2 = datos[0];
		}
		if (!(situacionColumna3 == null || situacionColumna3.equals(""))) {
			String datos[] = situacionColumna3.split("#");
			Columna3 = datos[0];
		}
		if (!(situacionColumna4 == null || situacionColumna4.equals(""))) {
			String datos[] = situacionColumna4.split("#");
			Columna4 = datos[0];
		}
		String sSituacion = getItem(ITEMS.txtsituacion_dsp_gen).getValue();
		switch (sSituacion) {
		// Si encontramos en la consulta el estado comprobamos si
		// ya estaban usandolos con el valor estático para ponerle el valor al combo
		case "0":
			fmCombo.addItem("0-Basica");
			if (Columna1.equals("0"))
				fmCombo.setValue("0-Basica");
			fmCombo2.addItem("0-Basica");
			if (Columna2.equals("0"))
				fmCombo2.setValue("0-Basica");
			fmCombo3.addItem("0-Basica");
			if (Columna3.equals("0"))
				fmCombo3.setValue("0-Basica");
			fmCombo4.addItem("0-Basica");
			if (Columna4.equals("0"))
				fmCombo4.setValue("0-Basica");
			break;
		case "2":
			fmCombo.addItem("0-Basica");
			fmCombo.addItem("2-Muestra");		
			if (Columna1.equals("2"))
				fmCombo.setValue("2-Muestra");
			fmCombo2.addItem("0-Basica");
			fmCombo2.addItem("2-Muestra");
			if (Columna2.equals("2"))
				fmCombo2.setValue("2-Muestra");
			fmCombo3.addItem("0-Basica");
			fmCombo3.addItem("2-Muestra");
			if (Columna3.equals("2"))
				fmCombo3.setValue("2-Muestra");
			fmCombo4.addItem("0-Basica");
			fmCombo4.addItem("2-Muestra");
			if (Columna4.equals("2"))
				fmCombo4.setValue("2-Muestra");
			break;
		case "4":
			fmCombo.addItem("0-Basica");
			fmCombo.addItem("2-Muestra");		
			fmCombo.addItem("4-Inspeccion");
			if (Columna1.equals("4"))
				fmCombo.setValue("4-Inspeccion");
			fmCombo2.addItem("0-Basica");
			fmCombo2.addItem("2-Muestra");		
			fmCombo2.addItem("4-Inspeccion");
			if (Columna2.equals("4"))
				fmCombo2.setValue("4-Inspeccion");
			fmCombo3.addItem("0-Basica");
			fmCombo3.addItem("2-Muestra");		
			fmCombo3.addItem("4-Inspeccion");
			if (Columna3.equals("4"))
				fmCombo3.setValue("4-Inspeccion");
			fmCombo4.addItem("0-Basica");
			fmCombo4.addItem("2-Muestra");		
			fmCombo4.addItem("4-Inspeccion");
			if (Columna4.equals("4"))
				fmCombo4.setValue("4-Inspeccion");
			break;
		case "6":
			fmCombo.addItem("0-Basica");
			fmCombo.addItem("2-Muestra");		
			fmCombo.addItem("4-Inspeccion");
			fmCombo.addItem("6-Massproduction");
			if (Columna1.equals("6"))
				fmCombo.setValue("6-Massproduction");
			fmCombo2.addItem("0-Basica");
			fmCombo2.addItem("2-Muestra");		
			fmCombo2.addItem("4-Inspeccion");
			fmCombo2.addItem("6-Massproduction");
			if (Columna2.equals("6"))
				fmCombo2.setValue("6-Massproduction");
			fmCombo3.addItem("0-Basica");
			fmCombo3.addItem("2-Muestra");		
			fmCombo3.addItem("4-Inspeccion");
			fmCombo3.addItem("6-Massproduction");
			if (Columna3.equals("6"))
				fmCombo3.setValue("6-Massproduction");
			fmCombo4.addItem("0-Basica");
			fmCombo4.addItem("2-Muestra");		
			fmCombo4.addItem("4-Inspeccion");
			fmCombo4.addItem("6-Massproduction");
			if (Columna4.equals("6"))
				fmCombo4.setValue("6-Massproduction");
			break;
		case "8":
			fmCombo.addItem("0-Basica");
			fmCombo.addItem("2-Muestra");		
			fmCombo.addItem("4-Inspeccion");
			fmCombo.addItem("6-Massproduction");
			fmCombo.addItem("8-Comercial");
			if (Columna1.equals("8"))
				fmCombo.setValue("8-Comercial");
			fmCombo2.addItem("0-Basica");
			fmCombo2.addItem("2-Muestra");		
			fmCombo2.addItem("4-Inspeccion");
			fmCombo2.addItem("6-Massproduction");
			fmCombo2.addItem("8-Comercial");	
			if (Columna2.equals("8"))
				fmCombo2.setValue("8-Comercial");
			fmCombo3.addItem("0-Basica");
			fmCombo3.addItem("2-Muestra");		
			fmCombo3.addItem("4-Inspeccion");
			fmCombo3.addItem("6-Massproduction");
			fmCombo3.addItem("8-Comercial");
			if (Columna3.equals("8"))
				fmCombo3.setValue("8-Comercial");
			fmCombo4.addItem("0-Basica");
			fmCombo4.addItem("2-Muestra");		
			fmCombo4.addItem("4-Inspeccion");
			fmCombo4.addItem("6-Massproduction");
			fmCombo4.addItem("8-Comercial");
			if (Columna4.equals("8"))
				fmCombo4.setValue("8-Comercial");
		}
	}

	@Override
	public void formPreLookup(FMEvent fmEvent) throws OTException {
		super.formPreLookup(fmEvent);
		if (fmEvent.isCancelled()) {
			fmEvent.setRecall(true);
			return;
		}
		int iCancel = fmEvent.getCancel();
		String sControlName = fmEvent.getSourceName();
		String sQuery = fmEvent.getQuery();
		String sRestr = fmEvent.getValue();
		// Modificamos el lookup para que filtre por la lista que tiene indicada en la
		// caracteristica.
		fmEvent.setRecall(true);
		if (sControlName.equals("txtvalorlista1")) {
			connSdic = session.getConnectionSource();
			connData = session.getConnectionData();
			try {
				String sTipoFiltro = getItem(ITEMS.xtipofiltrolista).getValue();
				String sArticuloFiltro = getItem(ITEMS.txtequivalente_id).getValue();
				String sSitucionFiltro = getItem(ITEMS.txtsituacion_dsp).getValue();
				String sEmpresa = getItem(ITEMS.txtempresa_id).getValue();
				if (!(sTipoFiltro == null || sTipoFiltro.equals(""))) {
					if (sTipoFiltro.equals("0")) { // caracteristica
						String sCaracteristicaFiltro = getItem(ITEMS.txtcampofiltrolista).getValue();
						if (!(sCaracteristicaFiltro == null || sCaracteristicaFiltro.equals(""))) {
							String sql = "select xvalorlista1 from " + connSdic.translateTable("s_art_carac")
									+ " where xarticulo_id='" + sArticuloFiltro + "' and xsituacion_dsp='"
									+ sSitucionFiltro + "'" + " and xcaracteristica_id='" + sCaracteristicaFiltro + "'";

							oRes = connData.openSQL(sql);

							if (oRes.moveNext()) {
								String sValorFiltro = oRes.getString("xvalorlista1");
								if (!(sValorFiltro == null || sValorFiltro.equals(""))) {
									String sLista_id = getItem(ITEMS.txtlista1).getValue();
									if (!(sLista_id == null || sLista_id.equals(""))) {
										sRestr = fmEvent.getValue() + " sul_art_listas.xlista_id='" + sLista_id + "'"
												+ " and sul_art_listas.xfiltro_id='" + sValorFiltro + "'";
										fmEvent.setValue(sRestr);
									}
								}
							}
							oRes.close();
						}
					}
					if (sTipoFiltro.equals("1")) { // Campo
						String sTabla = getItem(ITEMS.txtvalorfiltro).getValue();
						String sCampo = getItem(ITEMS.txtcampofiltrolista).getValue();
						if (!(sCampo == null || sCampo.equals(""))) {
							if (!(sTabla == null || sTabla.equals(""))) {
								String sql = "select " + sCampo + " from " + connSdic.translateTable(sTabla)
										+ " where xarticulo_id='" + sArticuloFiltro + "'" + " and xempresa_id='"
										+ sEmpresa + "'";

								oRes = connData.openSQL(sql);

								if (oRes.moveNext()) {
									String sValorFiltro = oRes.getString(sCampo);
									if (!(sValorFiltro == null || sValorFiltro.equals(""))) {
										String sLista_id = getItem(ITEMS.txtlista1).getValue();

										if (!(sLista_id == null || sLista_id.equals(""))) {
											sRestr = fmEvent.getValue() + " sul_art_listas.xlista_id='" + sLista_id
													+ "'" + " and sul_art_listas.xfiltro_id='" + sValorFiltro + "'";
											fmEvent.setValue(sRestr);
										}
									}
								}
								oRes.close();
							}
						}
					}
				} else {
					String sLista_id = getItem(ITEMS.txtlista1).getValue();
					if (!(sLista_id == null || sLista_id.equals(""))) {
						sRestr = fmEvent.getValue() + " sul_art_listas.xlista_id='" + sLista_id + "'";
						fmEvent.setValue(sRestr);
					}
				}
			} catch (DAException e) {
				e.printStackTrace();
			}
		}
		fmEvent.setCancel(iCancel);
		fmEvent.setQuery(sQuery);
		fmEvent.setValue(sRestr);
	}

	@Override
	public void viewClick(FMEvent fmEvent) throws OTException {
		// TODO Auto-generated method stub
		super.viewClick(fmEvent);
		fmEvent.setRecall(true);
		String sViewName = fmEvent.getSourceName();
		connSdic = session.getConnectionSource();
		connData = session.getConnectionData();
		String sUsuario = session.getUserInfo().getUserName();

		if (sViewName.equals("cmdaceptar")) {
			String sSituacion = getItem(ITEMS.txtsituacion_dsp).getValue();
			String sArticulo = getItem(ITEMS.txtequivalente_id).getValue();
			String sCaracteristica = getItem(ITEMS.txtcaracteristica_id_c).getValue();
			String sTipo = getItem(ITEMS.txttipo_c).getValue();
			String sEmpresa = getItem(ITEMS.txtempresa_id).getValue();
			sUsuario = session.getUserInfo().getUserName();
			Date fechaHoy = new Date();
			try {
				String sql = "select xdepartamento from " + connSdic.translateTable("s_usuarios_fichada")
						+ " where xusuario_id='" + sUsuario + "'";
				oRes = connData.openSQL(sql);
				if (oRes.moveNext()) {
					String sDepartamento = oRes.getString("xdepartamento");
					if (sDepartamento.equals("SAT")) {
						getItem(ITEMS.txtusu_mod_calidad).setValue(sUsuario);
						getItem(ITEMS.txtfech_mod_calidad).setValue(fechaHoy);
						getItem(ITEMS.txtmod_calidad).setValue("-1");
					} else if (sDepartamento.equals("PRO")) {
						getItem(ITEMS.txtusu_mod_producto).setValue(sUsuario);
						getItem(ITEMS.txtfech_mod_producto).setValue(fechaHoy);
						getItem(ITEMS.txtmod_producto).setValue("-1");
					}
				}
				oRes.close();
			} catch (DAException e) {
				e.printStackTrace();
			}
			// guardan datos y volvemos a pantalla principal, refrescamos formulario.
			FMWindow oWindow = (FMWindow) fmObject.getContainer(CONTAINERS.introduceDatos);
			oWindow.close();
			fmObject.save();
			fmObject.refreshData();
		} else if (sViewName.equals("cmdcancelar")) {

			FMWindow oWindow = (FMWindow) fmObject.getContainer(CONTAINERS.introduceDatos);
			oWindow.close();
		}

		else if (sViewName.equals("cmdcargardatos")) {
			// Crea todos los datos de las caracteristicas
			// referentes al articulo en funcion a su familia y subfamilia que coincidan con
			// las caracteristicas existentes.
			crearCaracteristicasArticulo();
			boObject.readRefresh();
		} else if (sViewName.equals("cmdmarcartodo")) {
//			getView(VIEWS.checkbasica).setValue(true);
//			getView(VIEWS.checkcomercial).setValue(true);
//			getView(VIEWS.checkinspeccion).setValue(true);
//			getView(VIEWS.checkmuestra).setValue(true);
//			getView(VIEWS.checkpedido).setValue(true);
//			getView(VIEWS.checkmassproduction).setValue(true);

		} else if (sViewName.equals("cmddesmarcar")) {
//			getView(VIEWS.checkbasica).setValue(false);
//			getView(VIEWS.checkcomercial).setValue(false);
//			getView(VIEWS.checkinspeccion).setValue(false);
//			getView(VIEWS.checkmuestra).setValue(false);
//			getView(VIEWS.checkpedido).setValue(false);
//			getView(VIEWS.checkmassproduction).setValue(false);
		} else if (sViewName.equals("cmdduplicar")) {
			String sEmpresa = getItem(ITEMS.txtempresa_id).getValue();
			String sArticulo = getItem(ITEMS.txtequivalente_id).getValue();
			String[] datos = getItem(ITEMS.txtsituacionorigen).getValue().split("-");
			String sSituacionOrigen = datos[0];
			datos = getItem(ITEMS.txtsituaciondestino).getValue().split("-");
			String sSituacionDestino = datos[0];
			int iSituacionOrigen = Integer.parseInt(sSituacionOrigen);
			int iSituacionDestino = Integer.parseInt(sSituacionDestino);
			if (iSituacionOrigen < iSituacionDestino) {
				int respuesta = SUL_UTILS_ART.duplicarValoresDSP(session, sSituacionDestino, sSituacionOrigen, sEmpresa,
						sArticulo);
				if (respuesta == 0) {
					String sMensaje = "Datos duplicados correctamente!";
					fmObject.showMessageText(sMensaje, "Aceptar");
				} else {
					String sMensaje = "Error al duplicar los datos!";
					fmObject.showMessageText(sMensaje, "Aceptar");
				}
				formReadRecord(fmEvent);
			} else {
				String sMensaje = "No puede modificar un estado anterior!";
				fmObject.showMessageText(sMensaje, "Aceptar");
			}
			FMWindow oWindow = (FMWindow) fmObject.getContainer(CONTAINERS.duplicarValores);
			oWindow.close();
		} else if (sViewName.equals("cmdduplicardatos")) {
			FMWindow oWindow = (FMWindow) fmObject.getContainer(CONTAINERS.duplicarValores);
			oWindow.openModal();
		} else if (sViewName.equals("cmdcancelardup")) {
			FMWindow oWindow = (FMWindow) fmObject.getContainer(CONTAINERS.duplicarValores);
			oWindow.close();
		} else if (sViewName.equals("checknopasa")) {
			String sNopasa = getView(VIEWS.checknopasa).getValue();
			if (sNopasa.equals("-1")) {
				getItem(ITEMS.txtvalorpasa1).setValue(0);
			}
		} else if (sViewName.equals("txtvalorpasa1")) {
			String sPasa = getView(VIEWS.txtvalorpasa1).getValue();
			if (sPasa.equals("-1")) {
				getView(VIEWS.checknopasa).setValue(0);
			}
		} else if (sViewName.equals("cmdduplicardatosart")) {
			FMWindow oWindow = (FMWindow) fmObject.getContainer(CONTAINERS.duplicarArticulo);
			oWindow.openModal();
		} else if (sViewName.equals("cmdcancelarart")) {
			FMWindow oWindow = (FMWindow) fmObject.getContainer(CONTAINERS.duplicarArticulo);
			oWindow.close();
		} else if (sViewName.equals("cmdduplicarart")) {
			// Actualizar datos de un articulo que elijamos al artículo de nuestro
			// formulario.
			String sArticulo = getItem(ITEMS.txtequivalente_id).getValue();
			String sEmpresa = getItem(ITEMS.txtempresa_id).getValue();
			String sArticuloPDuplicar = getItem(ITEMS.txtarticulo_id_duplica).getValue();
			String sApartados = "";
			String sEstados = "";

			if (getView(VIEWS.chkproductinf).getValue().equals("-1")) {
				sApartados = "'01'";
			}
			if (getView(VIEWS.chkcertificados).getValue().equals("-1")) {
				if (!sApartados.equals(""))
					sApartados += ",";
				sApartados += "'02'";
			}
			if (getView(VIEWS.checkpackaging).getValue().equals("-1")) {
				if (!sApartados.equals(""))
					sApartados += ",";
				sApartados += "'03'";
			}
			if (getView(VIEWS.chkcomponents).getValue().equals("-1")) {
				if (!sApartados.equals(""))
					sApartados += ",";
				sApartados += "'04'";
			}
			if (getView(VIEWS.chkgeneral).getValue().equals("-1")) {
				if (!sApartados.equals(""))
					sApartados += ",";
				sApartados += "'05'";
			}
			if (getView(VIEWS.chkled).getValue().equals("-1")) {
				if (!sApartados.equals(""))
					sApartados += ",";
				sApartados += "'06'";
			}
			if (getView(VIEWS.chkledmain).getValue().equals("-1")) {
				if (!sApartados.equals(""))
					sApartados += ",";
				sApartados += "'07'";
			}
			if (getView(VIEWS.chkdriver).getValue().equals("-1")) {
				if (!sApartados.equals(""))
					sApartados += ",";
				sApartados += "'08'";
			}
			if (getView(VIEWS.chkcontrol).getValue().equals("-1")) {
				if (!sApartados.equals(""))
					sApartados += ",";
				sApartados += "'09'";
			}
			if (getView(VIEWS.chkfan).getValue().equals("-1")) {
				if (!sApartados.equals(""))
					sApartados += ",";
				sApartados += "'10'";
			}
			if (getView(VIEWS.chkdimensions).getValue().equals("-1")) {
				if (!sApartados.equals(""))
					sApartados += ",";
				sApartados += "'11'";
			}
			if (getView(VIEWS.chkremote).getValue().equals("-1")) {
				if (!sApartados.equals(""))
					sApartados += ",";
				sApartados += "'12'";
			}
			if (getView(VIEWS.chktest).getValue().equals("-1")) {
				if (!sApartados.equals(""))
					sApartados += ",";
				sApartados += "'13'";
			}
			if (getView(VIEWS.chkdatoschequeo).getValue().equals("-1")) {
				if (!sApartados.equals(""))
					sApartados += ",";
				sApartados += "'14'";
			}

			// Comprobamos estados

			if (getView(VIEWS.chkbasica).getValue().equals("-1")) {
				if (!sEstados.equals(""))
					sEstados += ",";
				sEstados += "'0'";
			}
			if (getView(VIEWS.chkmuestra).getValue().equals("-1")) {
				if (!sEstados.equals(""))
					sEstados += ",";
				sEstados += "'2'";
			}
			if (getView(VIEWS.chkinspeccion).getValue().equals("-1")) {
				if (!sEstados.equals(""))
					sEstados += ",";
				sEstados += "'4'";
			}
			if (getView(VIEWS.chkmass).getValue().equals("-1")) {
				if (!sEstados.equals(""))
					sEstados += ",";
				sEstados += "'6'";
			}
			if (getView(VIEWS.chkcomercial).getValue().equals("-1")) {
				if (!sEstados.equals(""))
					sEstados += ",";
				sEstados += "'8'";
			}

			crearCaracteristicasArticulo();

			String sql = "update art set art.xvalorint1= carac2.xvalorint1,art.xvalorint2= carac2.xvalorint2,art.xvalorint3= carac2.xvalorint3,art.xvalorint4= carac2.xvalorint4,art.xvalorint5= carac2.xvalorint5, art.xvalorint6= carac2.xvalorint6,"
					+ " art.xvalordecimal1= carac2.xvalordecimal1,art.xvalordecimal2= carac2.xvalordecimal2,art.xvalordecimal3= carac2.xvalordecimal3,art.xvalordecimal4= carac2.xvalordecimal4,art.xvalordecimal5= carac2.xvalordecimal5, art.xvalordecimal6= carac2.xvalordecimal6,"
					+ " art.xvalorlista1= carac2.xvalorlista1,"
					+ " art.xvalortexto1= carac2.xvalortexto1,art.xvalortexto2= carac2.xvalortexto2,art.xvalortexto3= carac2.xvalortexto3,art.xvalortexto4= carac2.xvalortexto4, art.xvalortexto5= carac2.xvalortexto5,art.xvalortexto6= carac2.xvalortexto6,"
					+ " art.xvalorpasa1= carac2.xvalorpasa1" + " from " + connSdic.translateTable("s_art_carac")
					+ " art inner join " + connSdic.translateTable("s_art_carac") + " carac2 on carac2.xarticulo_id='"
					+ sArticuloPDuplicar
					+ "' and art.xcaracteristica_id=carac2.xcaracteristica_id and carac2.xsituacion_dsp=art.xsituacion_dsp "
					+ "inner join imp.s_caracteristicas car on car.xcaracteristica_id = art.xcaracteristica_id "
					+ "where art.xarticulo_id='" + sArticulo + "'";
			if (!sApartados.equals("")) {
				sql += " and car.xapartado_id in(" + sApartados + ")";
			}
			if (!sEstados.equals("")) {
				sql += " and art.xsituacion_dsp in(" + sEstados + ")";
			}
			connData.execSQL(sql);
			rellenarPanelesSimplificado(sArticulo, sEmpresa);

			String[] SituacionDatos1 = situacionColumna1.split("#");
			String[] SituacionDatos2 = situacionColumna2.split("#");
			String[] SituacionDatos3 = situacionColumna3.split("#");
			String[] SituacionDatos4 = situacionColumna4.split("#");
			String sSituacion1 = SituacionDatos1[0];
			String sSituacion2 = SituacionDatos2[0];
			String sSituacion3 = SituacionDatos3[0];
			String sSituacion4 = SituacionDatos4[0];

			if (!(sSituacion1 == null || sSituacion1.equals(""))) {
				rellenarRepuestosLink(sEmpresa, sArticulo, sSituacion1, 1);
			}
			if (!(sSituacion2 == null || sSituacion2.equals(""))) {
				rellenarRepuestosLink(sEmpresa, sArticulo, sSituacion2, 2);
			}
			if (!(sSituacion3 == null || sSituacion3.equals(""))) {
				rellenarRepuestosLink(sEmpresa, sArticulo, sSituacion3, 3);
			}
			if (!(sSituacion4 == null || sSituacion4.equals(""))) {
				rellenarRepuestosLink(sEmpresa, sArticulo, sSituacion4, 4);
			}

			fmObject.showMessageText("Datos copiados correctamente", "Aceptar");
			FMWindow oWindow = (FMWindow) fmObject.getContainer(CONTAINERS.duplicarArticulo);
			oWindow.close();
		} else if (sViewName.equals("cmdcancelarrart")) {
			FMWindow oWindow = (FMWindow) fmObject.getContainer(CONTAINERS.duplicarArticulo);
			oWindow.close();
		} else if (sViewName.equals("cmddescripcion")) {
			buscarDescripcion();
		} else if (sViewName.equals("cmdborrardatos")) {
			getItem(ITEMS.txtvalortexto1).setValue("");
			getItem(ITEMS.txtvalortexto2).setValue("");
			getItem(ITEMS.txtvalortexto3).setValue("");
			getItem(ITEMS.txtvalortexto4).setValue("");
			getItem(ITEMS.txtvalortexto5).setValue("");
			getItem(ITEMS.txtvalortexto6).setValue("");

			getItem(ITEMS.txtvalorint1).setValue("");
			getItem(ITEMS.txtvalorint2).setValue("");
			getItem(ITEMS.txtvalorint3).setValue("");
			getItem(ITEMS.txtvalorint4).setValue("");
			getItem(ITEMS.txtvalorint5).setValue("");
			getItem(ITEMS.txtvalorint6).setValue("");

			getItem(ITEMS.txtvalordecimal1).setValue("");
			getItem(ITEMS.txtvalordecimal2).setValue("");
			getItem(ITEMS.txtvalordecimal3).setValue("");
			getItem(ITEMS.txtvalordecimal4).setValue("");
			getItem(ITEMS.txtvalordecimal5).setValue("");
			getItem(ITEMS.txtvalordecimal6).setValue("");

			getItem(ITEMS.txtvalorlista1).setValue("");

		} else if (sViewName.equals("cmd_borrar")) {
			FMWindow oWindow = (FMWindow) fmObject.getContainer("borrarDatos");
			oWindow.openModal();
		} else if (sViewName.equals("cmd_aceptarborrado")) {
			String sEstado = getItem(ITEMS.aux_estado).getValue();
			String sEstadoDes = getItem(ITEMS.aux_estado).getDescription();
			String sArticulo = getItem(ITEMS.txtequivalente_id).getValue();

			if (!(sEstado == null || sEstado.equals(""))) {
				String sMensaje = "Esta seguro que quiere eliminar el estado " + sEstadoDes;
				int iRt = fmObject.showMessageText(1, sMensaje, "Sí/No", 1, "Borrar estado " + sEstadoDes);
				if (iRt == 1) {
					// SI
					String sql = " delete imp.s_art_carac " + " where xarticulo_id='" + sArticulo
							+ "' and xsituacion_dsp='" + sEstado + "'";
					connData.execSQL(sql);

					sMensaje = "Se han eliminado los datos del estado " + sEstadoDes + "!";
					fmObject.showMessageText(sMensaje, "Aceptar");
					viewClick(new FMEvent(fmObject, "cmdcargardatos"));
					FMWindow oWindow = (FMWindow) fmObject.getContainer("borrarDatos");
					oWindow.close();
				} else {
					// NO
				}
			}

		} else if (sViewName.equals("cmd_cancelarborrado")) {
			FMWindow oWindow = (FMWindow) fmObject.getContainer("borrarDatos");
			oWindow.close();
		} else if (sViewName.equals("cmd_cambiarsituacion")) {

			String sSituacion = getItem(ITEMS.txtsituacion_dsp_gen).getDescription();
			String sMensaje = "El articulo se encuentra en la situación " + sSituacion
					+ ". ¿Quiere avanzar al siguiente estado?";
			int iRt = fmObject.showMessageText(1, sMensaje, "Sí/No", 1, "Actualizar situación");
			if (iRt == 1) {
				sSituacion = getItem(ITEMS.txtsituacion_dsp_gen).getValue();
				String sArticulo = getItem(ITEMS.txtequivalente_id).getValue();
				String sEmpresa=getItem(ITEMS.txtempresa_id).getValue();

				int iSiguienteSituacion=0;
				String sObligaTabla = "";
				switch (sSituacion) {
				case "0":
					sObligaTabla = "xbasicaobliga";
					iSiguienteSituacion=2;
					break;
				case "2":
					sObligaTabla = "xmuestraobliga";
					iSiguienteSituacion=4;
					break;
				case "4":
					sObligaTabla = "xinspeccionobliga";
					iSiguienteSituacion=6;
					break;
				case "6":
					sObligaTabla = "xmassobliga";
					iSiguienteSituacion=8;
					break;
				case "8":
					sObligaTabla = "xcomercialobliga";
					iSiguienteSituacion=99;
					break;
				}
				boolean caracteristicasPendientes = false;
				ArrayList<String> listaCaracteristicas = new ArrayList<>();
				String sql = "select car.xnombre1,car.xnombre2,car.xnombre3,car.xnombre4,car.xnombre5,car.xnombre6,car.xnombre7,car.xnombre8,car.xnombre9,car.xnombre10,car.xcaracteristica_id "
						+ ",case car.xtipo_valor " + "when 0 then cast(art.xvalorpasa1 as varchar) "
						+ "when 1 then cast(art.xvalorpasa1 as varchar) " + "when 2 then "
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
						+ " ELSE ' / ' + format(art.xvalordecimal10,'n','es-es') END" + " end as valores "
						+ "from imp.s_caracteristicas car inner join imp.s_art_carac art"
						+ "  on art.xcaracteristica_id=car.xcaracteristica_id where xarticulo_id='" + sArticulo
						+ "' and " + sObligaTabla + "=-1 and art.xsituacion_dsp=" + sSituacion + " and art.xempresa_id='"+sEmpresa+"'";
				oRes = connData.openSQL(sql);
				while (oRes.moveNext()) {
					String sNombre1 = oRes.getString("xnombre1");
					String sNombre2 = oRes.getString("xnombre2");
					String sNombre3 = oRes.getString("xnombre3");
					String sNombre4 = oRes.getString("xnombre4");
					String sNombre5 = oRes.getString("xnombre5");
					String sNombre6 = oRes.getString("xnombre6");
					String sNombre7 = oRes.getString("xnombre7");
					String sNombre8 = oRes.getString("xnombre8");
					String sNombre9 = oRes.getString("xnombre9");
					String sNombre10 = oRes.getString("xnombre10");

					String sCaracteristica = oRes.getString("xcaracteristica_id");

					String sValores = oRes.getString("valores");
					String[] valoresDividos = sValores.split("/");
					if (!(sNombre1 == null || sNombre1.equals(""))) {
						if (valoresDividos[0] == null || valoresDividos[0].equals("")) {
							caracteristicasPendientes = true;
							listaCaracteristicas.add(sCaracteristica);
						} else {
							if (!(sNombre2 == null || sNombre2.equals(""))) {
								if (valoresDividos.length >= 2) {
									if (valoresDividos[1] == null || valoresDividos[1].equals("")) {
										caracteristicasPendientes = true;
										listaCaracteristicas.add(sCaracteristica);
									} else {
										if (!(sNombre3 == null || sNombre3.equals(""))) {
											if (valoresDividos.length >= 3) {
												if (valoresDividos[2] == null || valoresDividos[2].equals("")) {
													caracteristicasPendientes = true;
													listaCaracteristicas.add(sCaracteristica);
												} else {
													if (!(sNombre4 == null || sNombre4.equals(""))) {
														if (valoresDividos.length >= 4) {
															if (valoresDividos[3] == null
																	|| valoresDividos[3].equals("")) {
																caracteristicasPendientes = true;
																listaCaracteristicas.add(sCaracteristica);
															} else {
																if (!(sNombre5 == null || sNombre5.equals(""))) {
																	if (valoresDividos.length >= 5) {
																		if (valoresDividos[4] == null
																				|| valoresDividos[4].equals("")) {
																			caracteristicasPendientes = true;
																			listaCaracteristicas.add(sCaracteristica);
																		} else {
																			if (!(sNombre6 == null
																					|| sNombre6.equals(""))) {
																				if (valoresDividos.length >= 6) {
																					if (valoresDividos[5] == null
																							|| valoresDividos[5]
																									.equals("")) {
																						caracteristicasPendientes = true;
																						listaCaracteristicas
																								.add(sCaracteristica);
																					} else {
																						if (!(sNombre7 == null
																								|| sNombre7
																										.equals(""))) {
																							if (valoresDividos.length >= 7) {
																								if (valoresDividos[6] == null
																										|| valoresDividos[6]
																												.equals("")) {
																									caracteristicasPendientes = true;
																									listaCaracteristicas
																											.add(sCaracteristica);
																								} else {
																									if (!(sNombre8 == null
																											|| sNombre8
																													.equals(""))) {
																										if (valoresDividos.length >= 8) {
																											if (valoresDividos[7] == null
																													|| valoresDividos[7]
																															.equals("")) {
																												caracteristicasPendientes = true;
																												listaCaracteristicas
																														.add(sCaracteristica);
																											} else {
																												if (!(sNombre9 == null
																														|| sNombre9
																																.equals(""))) {
																													if (valoresDividos.length >= 9) {
																														if (valoresDividos[8] == null
																																|| valoresDividos[8]
																																		.equals("")) {
																															caracteristicasPendientes = true;
																															listaCaracteristicas
																																	.add(sCaracteristica);
																														} else {
																															if (!(sNombre10 == null
																																	|| sNombre10
																																			.equals(""))) {
																																if (valoresDividos.length >= 10) {
																																	if (valoresDividos[9] == null
																																			|| valoresDividos[9]
																																					.equals("")) {
																																		caracteristicasPendientes = true;
																																		listaCaracteristicas
																																				.add(sCaracteristica);
																																	} else {

																																	}
																																} else {
																																	caracteristicasPendientes = true;
																																	listaCaracteristicas
																																			.add(sCaracteristica);
																																}

																															}
																														}
																													} else {
																														caracteristicasPendientes = true;
																														listaCaracteristicas
																																.add(sCaracteristica);
																													}

																												}
																											}
																										} else {
																											caracteristicasPendientes = true;
																											listaCaracteristicas
																													.add(sCaracteristica);
																										}

																									}
																								}
																							} else {
																								caracteristicasPendientes = true;
																								listaCaracteristicas
																										.add(sCaracteristica);
																							}

																						}
																					}
																				} else {
																					caracteristicasPendientes = true;
																					listaCaracteristicas
																							.add(sCaracteristica);
																				}

																			}
																		}
																	} else {
																		caracteristicasPendientes = true;
																		listaCaracteristicas.add(sCaracteristica);
																	}

																}
															}
														} else {
															caracteristicasPendientes = true;
															listaCaracteristicas.add(sCaracteristica);
														}

													}
												}
											} else {
												caracteristicasPendientes = true;
												listaCaracteristicas.add(sCaracteristica);
											}

										}
									}
								} else {
									caracteristicasPendientes = true;
									listaCaracteristicas.add(sCaracteristica);
								}
							}
						}
					}

				}
				oRes.close();

				if (listaCaracteristicas.size() >= 1) {
					sMensaje = "Hay caracteristicas obligatorias sin rellenar, no se puede cambiar de situacion: "
							+ listaCaracteristicas;
					fmObject.showMessageText(sMensaje, "Aceptar");
				} else {
					sMensaje = "Se ha pasado el articulo "+sArticulo+" a la siguiente situacion";
					fmObject.showMessageText(sMensaje, "Aceptar");
					if(iSiguienteSituacion!=99) {
						sql="update imp.pl_articulos set xsituacion_dsp='"+iSiguienteSituacion+"' where xarticulo_id='"+sArticulo+"' and xempresa_id='"+sEmpresa+"'";
						connData.execSQL(sql);
						
						sql=" insert into imp.s_reg_estado_dsp(xestado_anterior,xestado_actual,xarticulo_id,xusuario,xfecha_sistema,xempresa_id)"
								+ " VALUES("+sSituacion+","+iSiguienteSituacion+",'"+sArticulo+"','"+sUsuario+"',getdate(),'"+sEmpresa+"')";
						connData.execSQL(sql);
		
						boObject.readRefresh();
					}else {
						sMensaje = "La situacion comercial en el articulo "+sArticulo+" ha sido validada.";
						fmObject.showMessageText(sMensaje, "Aceptar");
					}
				}
			}
		} else if (sViewName.equals("cmdimportar")) {
			FMObject.OpenParameters param = FMObject.getDefaultOpenParameters();

			// Para pasarle variables de entorno
			param.setModal(false);
			param.setMaximized(true);

			// param.setItemRestriction(BOObject.INIT_RESTRICTION_MODE, rItems, rValues);
			// setMultiform -> nos permite indicar si se ejecuta en ventana independiente o
			// dentro del ejecutor de ventanas.
			param.setMultiform(true);
			fmObject.openForm("s_importa_dsp", param);
			fmObject.getMainCard();
		}
			

	}

	private void crearCaracteristicasArticulo() throws DAException {
		BOSegment iPanel = boObject.getSegment(SEGMENTS.pnl_caracteristicas);
		int iLineas = iPanel.getValidRows();
		String sCaracteristicasExistentes = "";

		String sArticulo = getItem(ITEMS.txtequivalente_id).getValue();
		String sEmpresa = getItem(ITEMS.txtempresa_id).getValue();
		String valor = "";
		String sql = "select est.xlistav1,* from (select SUBSTRING(caract.xestados,0,len(caract.xestados)) as estados,* "
				+ " from (select *, " + " case car.xmuestra when -1 then cast('2,' as varchar)else '' end + "
				+ " case car.xbasica when -1 then cast('0,' as varchar) else '' end + "
				+ " case car.xcomercial when -1 then cast('8,' as varchar) else '' end + "
				+ " case car.xinspeccion when -1 then cast('4,' as varchar) else '' end+"
				+ " case xmassproduction when -1 then cast('6,' as varchar) else '' end as xestados from "
				+ connSdic.translateTable("s_caracteristicas") + " car) caract )est" + " inner join "
				+ connSdic.translateTable("s_carac_fam") + " fam on fam.xcaracteristica_id = est.xcaracteristica_id"
				+ " where xbaja=0";
		int i = 0;
		try (DAResultSet oRes = session.getConnectionData().openSQL(sql)) {
			while (oRes.moveNext()) {
				String sEstados = oRes.getString("estados");
				if (!(sEstados == null || sEstados.equals(""))) {
					String sTipoValor= oRes.getString("xtipo_valor");
					String sFamilia = oRes.getString("xfamilia_id");
					String sSfamilia = oRes.getString("xssfamilia_id");
					String sCaracteristica = oRes.getString("xcaracteristica_id");
					String sListav1 = oRes.getString("xlistav1");
					String sValorint1 = oRes.getString("xvalorint1");
					String sValorint2 = oRes.getString("xvalorint2");
					String sValorint3 = oRes.getString("xvalorint3");
					String sValorint4 = oRes.getString("xvalorint4");
					String sValorint5 = oRes.getString("xvalorint5");
					String sValorint6 = oRes.getString("xvalorint6");
					String sValordecimal1 = oRes.getString("xvalordecimal1");
					String sValordecimal2 = oRes.getString("xvalordecimal2");
					String sValordecimal3 = oRes.getString("xvalordecimal3");
					String sValordecimal4 = oRes.getString("xvalordecimal4");
					String sValordecimal5 = oRes.getString("xvalordecimal5");
					String sValordecimal6 = oRes.getString("xvalordecimal6");
					String sValorpasa1 = oRes.getString("xvalorpasa1");
					String sValortexto1 = oRes.getString("xvalortexto1");
					String sValortexto2 = oRes.getString("xvalortexto2");
					String sValortexto3 = oRes.getString("xvalortexto3");
					String sValortexto4 = oRes.getString("xvalortexto4");
					String sValortexto5 = oRes.getString("xvalortexto5");
					String sValortexto6 = oRes.getString("xvalortexto6"); 
					
					if(sTipoValor.equals("2")) {				
						sql="select xvalortexto1,xvalortexto2,xvalortexto3,xvalortexto4,xvalortexto5,xvalortexto6 from imp.s_caracteristicasmlg"
								+ " where xcaracteristica_id='"+sCaracteristica+"' and idioma=8" ;	
						oRes2 = connData.openSQL(sql);
						if(oRes2.moveNext()) {
							 sValortexto1 = oRes2.getString("xvalortexto1");
							 sValortexto2 = oRes2.getString("xvalortexto2");
							 sValortexto3 = oRes2.getString("xvalortexto3");
							 sValortexto4 = oRes2.getString("xvalortexto4");
							 sValortexto5 = oRes2.getString("xvalortexto5");
							 sValortexto6 = oRes2.getString("xvalortexto6");
						}
						oRes2.close();
					}
					// Comprobamos si el articulo tiene la misma familia que la caracteristica
					if (!(sFamilia == null || sFamilia.equals(""))) {
						if (!(sSfamilia == null || sSfamilia.equals(""))) {
							sql = "select  xfamilia_produc,xtecnologia,xarticulo_id from "
									+ connSdic.translateTable("pl_articulos") + " where xarticulo_id='" + sArticulo
									+ "' and xempresa_id='" + sEmpresa + "'";
							sql += " and xfamilia_produc='" + sFamilia + "' and xtecnologia='" + sSfamilia + "'";
						}
					}

					try (DAResultSet oRes2 = session.getConnectionData().openSQL(sql)) {
						if (oRes2.moveNext()) {
							String[] estados = sEstados.split(",");

							for (String estado : estados) {
								// Comprobamos si esa caracteristica con ese estado se encuentra ya insertada,
								// de ser asi no insertamos
								boolean existe = false;
								for (int z = 0; z < iLineas; z++) {
									String sCaracteristicaPanel = getItem(ITEMS.txtcaracteristica_id_c).getValue(z);
									String sSituacionPanel = getItem(ITEMS.txtsituacion_dsp).getValue(z);
									if (sCaracteristica.equals(sCaracteristicaPanel)) {
										if (estado.equals(sSituacionPanel)) {
											existe = true;
											break;
										}
									}
								}
								if (existe == false) {
									// Solo insertamos valores no nulos
									sql = " INSERT INTO imp.s_art_carac";
									sql += "(xempresa_id,xarticulo_id,xcaracteristica_id";
									if (!(estado == null || estado.equals(""))) {
										sql += ",xsituacion_dsp";
									}
									if (!(sValorint1 == null || sValorint1.equals(""))) {
										sql += ",xvalorint1";
										if (!(sValorint2 == null || sValorint2.equals(""))) {
											sql += ",xvalorint2";
											if (!(sValorint3 == null || sValorint3.equals(""))) {
												sql += ",xvalorint3";
												if (!(sValorint4 == null || sValorint4.equals(""))) {
													sql += ",xvalorint4";
													if (!(sValorint5 == null || sValorint5.equals(""))) {
														sql += ",xvalorint5";
														if (!(sValorint6 == null || sValorint6.equals(""))) {
															sql += ",xvalorint6";
														}
													}
												}
											}
										}
									}
									if (!(sValordecimal1 == null || sValordecimal1.equals(""))) {
										sql += ",xvalordecimal1";
										if (!(sValordecimal2 == null || sValordecimal2.equals(""))) {
											sql += ",xvalordecimal2";
											if (!(sValordecimal3 == null || sValordecimal3.equals(""))) {
												sql += ",xvalordecimal3";
												if (!(sValordecimal4 == null || sValordecimal4.equals(""))) {
													sql += ",xvalordecimal4";
													if (!(sValordecimal5 == null || sValordecimal5.equals(""))) {
														sql += ",xvalordecimal5";
														if (!(sValordecimal6 == null || sValordecimal6.equals(""))) {
															sql += ",xvalordecimal6";
														}
													}
												}
											}
										}
									}
									if (!(sListav1 == null || sListav1.equals(""))) {
										sql += ",xvalorlista1";
									}
									if (!(sValortexto1 == null || sValortexto1.equals(""))) {
										sql += ",xvalortexto1";
										if (!(sValortexto2 == null || sValortexto2.equals(""))) {
											sql += ",xvalortexto2";
											if (!(sValortexto3 == null || sValortexto3.equals(""))) {
												sql += ",xvalortexto3";
												if (!(sValortexto4 == null || sValortexto4.equals(""))) {
													sql += ",xvalortexto4";
													if (!(sValortexto5 == null || sValortexto5.equals(""))) {
														sql += ",xvalortexto5";
														if (!(sValortexto6 == null || sValortexto6.equals(""))) {
															sql += ",xvalortexto6";
														}
													}
												}
											}
										}
									}
									if (!(sValorpasa1 == null || sValorpasa1.equals(""))) {
										sql += ",xvalorpasa1";
									}
									sql += ")";
									sql += " VALUES('" + sEmpresa + "','" + sArticulo + "','" + sCaracteristica + "'";
									if (!(estado == null || estado.equals(""))) {
										sql += ",'" + estado + "'";
									}
									if (!(sValorint1 == null || sValorint1.equals(""))) {
										sql += ",'" + sValorint1 + "'";
										if (!(sValorint2 == null || sValorint2.equals(""))) {
											sql += ",'" + sValorint2 + "'";
											if (!(sValorint3 == null || sValorint3.equals(""))) {
												sql += ",'" + sValorint3 + "'";
												if (!(sValorint4 == null || sValorint4.equals(""))) {
													sql += ",'" + sValorint4 + "'";
													if (!(sValorint5 == null || sValorint5.equals(""))) {
														sql += ",'" + sValorint5 + "'";
														if (!(sValorint6 == null || sValorint6.equals(""))) {
															sql += ",'" + sValorint6 + "'";
														}
													}
												}
											}
										}
									}
									if (!(sValordecimal1 == null || sValordecimal1.equals(""))) {
										sql += ",'" + sValordecimal1 + "'";
										if (!(sValordecimal2 == null || sValordecimal2.equals(""))) {
											sql += ",'" + sValordecimal2 + "'";
											if (!(sValordecimal3 == null || sValordecimal3.equals(""))) {
												sql += ",'" + sValordecimal3 + "'";
												if (!(sValordecimal4 == null || sValordecimal4.equals(""))) {
													sql += ",'" + sValordecimal4 + "'";
													if (!(sValordecimal5 == null || sValordecimal5.equals(""))) {
														sql += ",'" + sValordecimal5 + "'";
														if (!(sValordecimal6 == null || sValordecimal6.equals(""))) {
															sql += ",'" + sValordecimal6 + "'";
														}
													}
												}
											}
										}
									}
									if (!(sListav1 == null || sListav1.equals(""))) {
										sql += ",'" + sListav1 + "'";
									}
									if (!(sValortexto1 == null || sValortexto1.equals(""))) {
										sql += ",'" + sValortexto1 + "'";
										if (!(sValortexto2 == null || sValortexto2.equals(""))) {
											sql += ",'" + sValortexto2 + "'";
											if (!(sValortexto3 == null || sValortexto3.equals(""))) {
												sql += ",'" + sValortexto3 + "'";
												if (!(sValortexto4 == null || sValortexto4.equals(""))) {
													sql += ",'" + sValortexto4 + "'";
													if (!(sValortexto5 == null || sValortexto5.equals(""))) {
														sql += ",'" + sValortexto5 + "'";
														if (!(sValortexto6 == null || sValortexto6.equals(""))) {
															sql += ",'" + sValortexto6 + "'";
														}
													}
												}
											}
										}
									}
									if (!(sValorpasa1 == null || sValorpasa1.equals(""))) {
										sql += ",'" + sValorpasa1 + "'";
									}
									sql += ")";
									connData.execSQL(sql);
								}
							}
						}
						oRes2.close();
					} catch (OTException ot) {
						ot.printStackTrace();
						if (oRes2 != null)
							oRes2.close();
						try {
							throw new PMException(session, ot);
						} catch (PMException e) {
							e.printStackTrace();
						}
					}
				}
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

	@Override
	public void containerDblClick(FMEvent fmEvent) throws OTException {
		// TODO Auto-generated method stub
		super.containerDblClick(fmEvent);
		fmEvent.setRecall(true);
		String sViewName = fmEvent.getSourceName();
		String sArticulos = getItem(ITEMS.txtequivalente_id).getValue();
		String sSituacionDSP = getItem(ITEMS.txtsituacion_dsp).getValue();

		FMGrid migrid = (FMGrid) (fmEvent.getFMObject().getContainer(sViewName));
		String sApartado = "";
		String[] datos = sViewName.split("_");
		if (datos.length >= 2) {
			sApartado = datos[1];
		}
		int iLineas = migrid.getCurrentRow();
		int lCol = fmEvent.getColumn();
		if (lCol == 3) {
			String sNombreColumna = getView(
					VIEWS.valueOf("txtvalormaestro_" + ApartadoEnum.valueOf("Apart_" + sApartado).nombreValor))
							.getCaption();
			String[] datosColumna = sNombreColumna.split("#");
			String sSituacion = datosColumna[0];
//				if (!sSituacion.equals(sSituacionDSP)) {
//					String sMensaje = "El artículo se encuentra en una situación diferente, no se puede editar!";
//					fmObject.showMessageText(sMensaje, "Aceptar");
//					return;
//				}
			String sCaracteristica = getItem(ITEMS
					.valueOf("txtcaracteristica_" + ApartadoEnum.valueOf("Apart_" + sApartado).caracteristicaValor))
							.getValue(iLineas);
			String sRefine = " s_art_carac.xsituacion_dsp='" + sSituacion + "' and s_art_carac.xcaracteristica_id='"
					+ sCaracteristica + "'";

			editarCampos(
					getItem(ITEMS.valueOf(
							"txtcaracteristica_" + ApartadoEnum.valueOf("Apart_" + sApartado).caracteristicaValor)),
					sRefine, sSituacion);
		}
		if (lCol == 4) {
			String sNombreColumna = getView(
					VIEWS.valueOf("txtvalormaestro_" + ApartadoEnum.valueOf("Apart_" + sApartado).nombreValor + "2"))
							.getCaption();
			String[] datosColumna = sNombreColumna.split("#");
			String sSituacion = datosColumna[0];
			if (!sSituacion.equals(sSituacionDSP)) {
//				String sMensaje = "El artículo se encuentra en una situación diferente, no se puede editar!";
//				fmObject.showMessageText(sMensaje, "Aceptar");
//				return;
			}
			String sCaracteristica = getItem(ITEMS
					.valueOf("txtcaracteristica_" + ApartadoEnum.valueOf("Apart_" + sApartado).caracteristicaValor))
							.getValue(iLineas);
			String sRefine = " s_art_carac.xsituacion_dsp='" + sSituacion + "' and s_art_carac.xcaracteristica_id='"
					+ sCaracteristica + "'";
			editarCampos(
					getItem(ITEMS.valueOf(
							"txtcaracteristica_" + ApartadoEnum.valueOf("Apart_" + sApartado).caracteristicaValor)),
					sRefine, sSituacion);
		}
		if (lCol == 5) {
			String sNombreColumna = getView(
					VIEWS.valueOf("txtvalormaestro_" + ApartadoEnum.valueOf("Apart_" + sApartado).nombreValor + "3"))
							.getCaption();
			String[] datosColumna = sNombreColumna.split("#");
			String sSituacion = datosColumna[0];
			if (!sSituacion.equals(sSituacionDSP)) {
//				String sMensaje = "El artículo se encuentra en una situación diferente, no se puede editar!";
//				fmObject.showMessageText(sMensaje, "Aceptar");
//				return;
			}
			String sCaracteristica = getItem(ITEMS
					.valueOf("txtcaracteristica_" + ApartadoEnum.valueOf("Apart_" + sApartado).caracteristicaValor))
							.getValue(iLineas);
			String sRefine = " s_art_carac.xsituacion_dsp='" + sSituacion + "' and s_art_carac.xcaracteristica_id='"
					+ sCaracteristica + "'";
			editarCampos(
					getItem(ITEMS.valueOf(
							"txtcaracteristica_" + ApartadoEnum.valueOf("Apart_" + sApartado).caracteristicaValor)),
					sRefine, sSituacion);
		}
		if (lCol == 6) {
			String sNombreColumna = getView(
					VIEWS.valueOf("txtvalormaestro_" + ApartadoEnum.valueOf("Apart_" + sApartado).nombreValor + "4"))
							.getCaption();
			String[] datosColumna = sNombreColumna.split("#");
			String sSituacion = datosColumna[0];
			if (!sSituacion.equals(sSituacionDSP)) {
//				String sMensaje = "El artículo se encuentra en una situación diferente, no se puede editar!";
//				fmObject.showMessageText(sMensaje, "Aceptar");
//				return;
			}
			String sCaracteristica = getItem(ITEMS
					.valueOf("txtcaracteristica_" + ApartadoEnum.valueOf("Apart_" + sApartado).caracteristicaValor))
							.getValue(iLineas);
			String sRefine = " s_art_carac.xsituacion_dsp='" + sSituacion + "' and s_art_carac.xcaracteristica_id='"
					+ sCaracteristica + "'";
			editarCampos(
					getItem(ITEMS.valueOf(
							"txtcaracteristica_" + ApartadoEnum.valueOf("Apart_" + sApartado).caracteristicaValor)),
					sRefine, sSituacion);
		}
	}

	public void editarCampos(BOItem boItem, String sRefine, String sSituacion) {

		// metodo que recoge la caracteristica que se va a editar enlazada con el
		// articulo.
//		getView(VIEWS.lblmensaje1).setValue("");
//		getView(VIEWS.lblmensaje2).setValue("");
//		getView(VIEWS.lblmensaje3).setValue("");
//		getView(VIEWS.lblmensaje4).setValue("");
//		getView(VIEWS.lblmensaje5).setValue("");
//		getView(VIEWS.lblmensaje6).setValue("");
		String sNombre1 = getItem(ITEMS.txtnombre1).getValue();
		String sNombre2 = getItem(ITEMS.txtnombre2).getValue();
		String sNombre3 = getItem(ITEMS.txtnombre3).getValue();
		String sNombre4 = getItem(ITEMS.txtnombre4).getValue();
		String sNombre5 = getItem(ITEMS.txtnombre5).getValue();
		String sNombre6 = getItem(ITEMS.txtnombre6).getValue();
		String sNombre7 = getItem(ITEMS.txtnombre7).getValue();
		String sNombre8 = getItem(ITEMS.txtnombre8).getValue();
		String sNombre9 = getItem(ITEMS.txtnombre9).getValue();
		String sNombre10 = getItem(ITEMS.txtnombre10).getValue();
		FMWindow oWindow = (FMWindow) fmObject.getContainer(CONTAINERS.introduceDatos);

		BOSegment iPanel = boObject.getSegment(SEGMENTS.pnl_caracteristicas);
		String sCaracteristica = boItem.getValue();
		int iLineas = iPanel.getValidRows();
		iPanel.refine("", "");
		iPanel.refine(sRefine, "");
		for (int i = 0; i < iLineas; i++) {

			String sCaracteristicaEdit = getItem(ITEMS.txtcaracteristica_id_c).getValue(i);
			String sEspecial = getItem(ITEMS.txtvalorcomercial).getValue(i);
			if (sEspecial == null)
				sEspecial = "0";
			if (sCaracteristicaEdit.equals(sCaracteristica) && sCaracteristica != null) {
				String sTipo = getItem(ITEMS.txttipo_c).getValue(i);

				// Despliega unos paneles u otro en función del tipo de valor.
				// boolean
				if (sTipo.equals("0")) {
					getContainer(CONTAINERS.framedecimales).setVisible(false);
					getContainer(CONTAINERS.frameintegers).setVisible(false);
					getContainer(CONTAINERS.framelistas).setVisible(false);
					getContainer(CONTAINERS.framepasa).setVisible(true);
					getContainer(CONTAINERS.frametexto).setVisible(false);
					getView(VIEWS.txtvalorpasa1).setTabIndex(0);
					getView(VIEWS.txtvalorpasa1).setFocus();
					getView(VIEWS.cmdaceptar).setTabIndex(1);

					recolocarVentanaDatos(oWindow, CONTAINERS.framepasa);

				} else
				// lista
				if (sTipo.equals("1")) {
					getContainer(CONTAINERS.framedecimales).setVisible(false);
					getContainer(CONTAINERS.frameintegers).setVisible(false);
					getContainer(CONTAINERS.framelistas).setVisible(true);
					recolocarVentanaDatos(oWindow, CONTAINERS.framelistas);

					getContainer(CONTAINERS.framepasa).setVisible(false);
					getContainer(CONTAINERS.frametexto).setVisible(false);
					getView(VIEWS.txtvalorlista1).setFocus();
					FMCombo fmCombo = (FMCombo) getView(VIEWS.txtvalorlista1);
					fmCombo.setSystemList(null);
					fmCombo.clearItems();
					String sLista_id = getItem(ITEMS.txtlista1).getValue();
					String sql;
					ArrayList<String> listaCodigos = new ArrayList<String>();
					ArrayList<String> listaValores = new ArrayList<String>();

					int iIdioma = session.getLanguageCode();

					try {
						sql = "select mlg.xlinea_id,mlg.xdescripcion from imp.sul_art_listasmlg mlg"
								+ " inner join imp.sul_art_listas lis on lis.xlista_id=mlg.xlista_id and lis.xlinea_id=mlg.xlinea_id "
								+ " where mlg.xlista_id='" + sLista_id + "' and idioma='" + iIdioma
								+ "' order by isnull(lis.xorden,99)";

						oRes2 = connData.openSQL(sql);
						int r = 0;
						while (oRes2.moveNext()) {
							listaCodigos.add(oRes2.getString("xlinea_id"));
							listaValores.add(oRes2.getString("xdescripcion"));
							r++;
						}
						oRes2.close();
						String[] listaCodes = new String[listaCodigos.size()];
						String[] listaValues = new String[listaValores.size()];
						for (int z = 0; z < listaCodigos.size(); z++) {
							listaCodes[z] = listaCodigos.get(z);
						}
						for (int z = 0; z < listaValores.size(); z++) {
							listaValues[z] = listaValores.get(z);
						}
						createSystemList("listaCombo", listaCodes, listaValues);
						getItem(ITEMS.txtvalorlista1).setListName("listaCombo");
					} catch (DAException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else
				// integer
				if (sTipo.equals("3")) {
					getContainer(CONTAINERS.framedecimales).setVisible(false);
					getContainer(CONTAINERS.frameintegers).setVisible(true);
					getContainer(CONTAINERS.framelistas).setVisible(false);
					getContainer(CONTAINERS.framepasa).setVisible(false);
					getContainer(CONTAINERS.frametexto).setVisible(false);
					recolocarVentanaDatos(oWindow, CONTAINERS.frameintegers);

					try {
						getItem(ITEMS.txtvalorint1).validate();
						getItem(ITEMS.txtvalorint2).validate();
						getItem(ITEMS.txtvalorint3).validate();
						getItem(ITEMS.txtvalorint4).validate();
						getItem(ITEMS.txtvalorint5).validate();
						getItem(ITEMS.txtvalorint6).validate();

					} catch (BOException e) {
						e.printStackTrace();
					}
				} else
				// decimal
				if (sTipo.equals("4")) {
					getContainer(CONTAINERS.framedecimales).setVisible(true);
					getContainer(CONTAINERS.frameintegers).setVisible(false);
					getContainer(CONTAINERS.framelistas).setVisible(false);
					getContainer(CONTAINERS.framepasa).setVisible(false);
					getContainer(CONTAINERS.frametexto).setVisible(false);
					recolocarVentanaDatos(oWindow, CONTAINERS.framedecimales);

					try {
						getItem(ITEMS.txtvalordecimal1).validate();
						getItem(ITEMS.txtvalordecimal2).validate();
						getItem(ITEMS.txtvalordecimal3).validate();
						getItem(ITEMS.txtvalordecimal4).validate();
						getItem(ITEMS.txtvalordecimal5).validate();
						getItem(ITEMS.txtvalordecimal6).validate();

					} catch (BOException e) {
						e.printStackTrace();
					}
				} else
				// texto
				if (sTipo.equals("2")) {
					getContainer(CONTAINERS.framedecimales).setVisible(false);
					getContainer(CONTAINERS.frameintegers).setVisible(false);
					getContainer(CONTAINERS.framelistas).setVisible(false);
					getContainer(CONTAINERS.framepasa).setVisible(false);
					getContainer(CONTAINERS.frametexto).setVisible(true);
					getView(VIEWS.cmdaceptar).setTabIndex(6);
					getContainer(CONTAINERS.frametexto).setCaption("Valor texto");
					getContainer(CONTAINERS.frametexto).setLocation(10, 0);
					recolocarVentanaDatos(oWindow, CONTAINERS.frametexto);

				}
				// Si no tiene indicado tipo no desplegamos ninguno, para evitar que introduzca
				// ningun dato
				else if (sTipo.equals("")) {
					getContainer(CONTAINERS.framedecimales).setVisible(false);
					getContainer(CONTAINERS.frameintegers).setVisible(false);
					getContainer(CONTAINERS.framelistas).setVisible(false);
					getContainer(CONTAINERS.framepasa).setVisible(false);
					getContainer(CONTAINERS.frametexto).setVisible(false);

				}

				if (sEspecial.equals("-1") && (sSituacion.equals("6") || sSituacion.equals("8"))) {
					getContainer(CONTAINERS.frametexto).setVisible(true);
					getContainer(CONTAINERS.frametexto).setLocation(730, 0);
					getContainer(CONTAINERS.frametexto).setCaption("Valor Comercial");

					// 1 label
					if ((!(sNombre1 == null || sNombre1.equals(""))) && (sNombre2 == null || sNombre2.equals(""))) {
						getContainer(CONTAINERS.frametexto).setHeight(58);
						int iLocalizacion = getContainer(CONTAINERS.frcuerpo).getTop()
								+ getContainer(CONTAINERS.frcuerpo).getHeight();
						getContainer(CONTAINERS.frametexto).setLocation(iLocalizacion, 0);
						int iAltoVentana = getContainer(CONTAINERS.frametexto).getTop()
								+ getContainer(CONTAINERS.frametexto).getHeight();
						oWindow.setHeight(iAltoVentana);
					}
					// 2 labels
					if ((!(sNombre2 == null || sNombre2.equals(""))) && (sNombre3 == null || sNombre3.equals(""))) {
						getContainer(CONTAINERS.frametexto).setHeight(88);
						int iLocalizacion = getContainer(CONTAINERS.frcuerpo).getTop()
								+ getContainer(CONTAINERS.frcuerpo).getHeight();
						getContainer(CONTAINERS.frametexto).setLocation(iLocalizacion, 0);
						int iAltoVentana = getContainer(CONTAINERS.frametexto).getTop()
								+ getContainer(CONTAINERS.frametexto).getHeight();
						oWindow.setHeight(iAltoVentana);
					}
					// 3 labels
					if ((!(sNombre3 == null || sNombre3.equals(""))) && (sNombre4 == null || sNombre4.equals(""))) {
						getContainer(CONTAINERS.frametexto).setHeight(118);
						int iLocalizacion = getContainer(CONTAINERS.frcuerpo).getTop()
								+ getContainer(CONTAINERS.frcuerpo).getHeight();
						getContainer(CONTAINERS.frametexto).setLocation(iLocalizacion, 0);
						int iAltoVentana = getContainer(CONTAINERS.frametexto).getTop()
								+ getContainer(CONTAINERS.frametexto).getHeight();
						oWindow.setHeight(iAltoVentana);
					}
					// 4 labels
					if ((!(sNombre4 == null || sNombre4.equals(""))) && (sNombre5 == null || sNombre5.equals(""))) {
						getContainer(CONTAINERS.frametexto).setHeight(148);
						int iLocalizacion = getContainer(CONTAINERS.frcuerpo).getTop()
								+ getContainer(CONTAINERS.frcuerpo).getHeight();
						getContainer(CONTAINERS.frametexto).setLocation(iLocalizacion, 0);
						int iAltoVentana = getContainer(CONTAINERS.frametexto).getTop()
								+ getContainer(CONTAINERS.frametexto).getHeight();
						oWindow.setHeight(iAltoVentana);
					}
					// 5 labels
					if ((!(sNombre5 == null || sNombre5.equals(""))) && (sNombre6 == null || sNombre6.equals(""))) {
						getContainer(CONTAINERS.frametexto).setHeight(178);
						int iLocalizacion = getContainer(CONTAINERS.frcuerpo).getTop()
								+ getContainer(CONTAINERS.frcuerpo).getHeight();
						getContainer(CONTAINERS.frametexto).setLocation(iLocalizacion, 0);
						int iAltoVentana = getContainer(CONTAINERS.frametexto).getTop()
								+ getContainer(CONTAINERS.frametexto).getHeight();
						oWindow.setHeight(iAltoVentana);
					}
					// 6 labels
					if ((!(sNombre6 == null || sNombre6.equals(""))) && (sNombre7 == null || sNombre7.equals(""))) {
						getContainer(CONTAINERS.frametexto).setHeight(208);
						int iLocalizacion = getContainer(CONTAINERS.frcuerpo).getTop()
								+ getContainer(CONTAINERS.frcuerpo).getHeight();
						getContainer(CONTAINERS.frametexto).setLocation(iLocalizacion, 0);
						int iAltoVentana = getContainer(CONTAINERS.frametexto).getTop()
								+ getContainer(CONTAINERS.frametexto).getHeight();
						oWindow.setHeight(iAltoVentana);
					}
					// 7 labels
					if ((!(sNombre7 == null || sNombre7.equals(""))) && (sNombre8 == null || sNombre8.equals(""))) {
						getContainer(CONTAINERS.frametexto).setHeight(238);
						int iLocalizacion = getContainer(CONTAINERS.frcuerpo).getTop()
								+ getContainer(CONTAINERS.frcuerpo).getHeight();
						getContainer(CONTAINERS.frametexto).setLocation(iLocalizacion, 0);
						int iAltoVentana = getContainer(CONTAINERS.frametexto).getTop()
								+ getContainer(CONTAINERS.frametexto).getHeight();
						oWindow.setHeight(iAltoVentana);
					}
					// 8 labels
					if ((!(sNombre8 == null || sNombre8.equals(""))) && (sNombre9 == null || sNombre9.equals(""))) {
						getContainer(CONTAINERS.frametexto).setHeight(268);
						int iLocalizacion = getContainer(CONTAINERS.frcuerpo).getTop()
								+ getContainer(CONTAINERS.frcuerpo).getHeight();
						getContainer(CONTAINERS.frametexto).setLocation(iLocalizacion, 0);
						int iAltoVentana = getContainer(CONTAINERS.frametexto).getTop()
								+ getContainer(CONTAINERS.frametexto).getHeight();
						oWindow.setHeight(iAltoVentana);
					}
					// 9 labels
					if ((!(sNombre9 == null || sNombre9.equals(""))) && (sNombre10 == null || sNombre10.equals(""))) {
						getContainer(CONTAINERS.frametexto).setHeight(298);
						int iLocalizacion = getContainer(CONTAINERS.frcuerpo).getTop()
								+ getContainer(CONTAINERS.frcuerpo).getHeight();
						getContainer(CONTAINERS.frametexto).setLocation(iLocalizacion, 0);
						int iAltoVentana = getContainer(CONTAINERS.frametexto).getTop()
								+ getContainer(CONTAINERS.frametexto).getHeight();
						oWindow.setHeight(iAltoVentana);
					}
					// 10 labels
					if (!(sNombre10 == null || sNombre10.equals(""))) {
						getContainer(CONTAINERS.frametexto).setHeight(328);
						int iLocalizacion = getContainer(CONTAINERS.frcuerpo).getTop()
								+ getContainer(CONTAINERS.frcuerpo).getHeight();
						getContainer(CONTAINERS.frametexto).setLocation(iLocalizacion, 0);
						int iAltoVentana = getContainer(CONTAINERS.frametexto).getTop()
								+ getContainer(CONTAINERS.frametexto).getHeight();
						oWindow.setHeight(iAltoVentana);
					}

				} else {

				}
				iPanel.setCurrentRow(i);

				String sUsuario = session.getUserInfo().getUserName();
				try {
					String sql = "select xusuario from " + connSdic.translateTable("s_permisos_dsp")
							+ " where xusuario='" + sUsuario + "' and xsituacion_dsp='" + sSituacion + "'";
					oRes = connData.openSQL(sql);
					if (oRes.moveNext()) {
						oRes.close();

						oWindow = (FMWindow) fmObject.getContainer(CONTAINERS.introduceDatos);
						oWindow.openModal();

					} else {
						oRes.close();
						oWindow = (FMWindow) fmObject.getContainer(CONTAINERS.introduceDatos);
						oWindow.openModal();
//						String sMensaje = "No tiene permisos para editar la situación seleccionada!";
//						fmObject.showMessageText(sMensaje, "Aceptar");
					}
				} catch (DAException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void ocultarVacios() {
		ApartadoEnum[] apartados = ApartadoEnum.values();
		for (int i = 0; i < apartados.length; i++) {
			if (getView(VIEWS.valueOf("txtcaracteristica_" + apartados[i].caracteristicaValor)).getValue(0)
					.equals("")) {
				getContainer(CONTAINERS.valueOf("collap_" + apartados[i].id)).setVisible(false);
			} else {
				getContainer(CONTAINERS.valueOf("collap_" + apartados[i].id)).setVisible(true);
			}
		}
		for (int i = 1; i < 10; i++) {
			if (getView(VIEWS.valueOf("txtcaracteristica_link" + i)).getValue(0).equals("")) {
				getContainer(CONTAINERS.valueOf("collap_link" + i)).setVisible(false);
			} else {
				getContainer(CONTAINERS.valueOf("collap_link" + i)).setVisible(true);
			}
		}
	}

	@Override
	public void formPreUpdateIn(FMEvent fmEvent) throws OTException {
		super.formPreUpdateIn(fmEvent);
		fmEvent.setRecall(true);
		// Comprobamos los valores que están marcados como obligatorios, si no están
		// rellenos sacamos mensaje.
		BOSegment iPanel = boObject.getSegment(SEGMENTS.pnl_caracteristicas);
		int iLineas = iPanel.getCurrentRows();

		for (int i = 0; i < iLineas; i++) {
			String sCaracteristica = getItem(ITEMS.txtcaracteristica_id_c).getValue(i);
			String sSituacion = getItem(ITEMS.txtsituacion_dsp).getValue(i);
			String sBuscarSituacion = "";
			if (sSituacion.equals("0")) {
				sBuscarSituacion = "xbasicaobliga";
			} else if (sSituacion.equals("2")) {
				sBuscarSituacion = "xmuestraobliga";
			} else if (sSituacion.equals("4")) {
				sBuscarSituacion = "xmassobliga";
			} else if (sSituacion.equals("6")) {
				sBuscarSituacion = "xcomercialobliga";
			} else if (sSituacion.equals("8")) {
				sBuscarSituacion = "xinspeccionobliga";
			} else if (sSituacion.equals("10")) {
				sBuscarSituacion = "xpedidoobliga";
			}
			if (!(sBuscarSituacion == null || sBuscarSituacion.equals(""))) {
				String sql = "select " + sBuscarSituacion + " from " + connSdic.translateTable("s_caracteristicas")
						+ " where xcaracteristica_id='" + sCaracteristica + "'";
				oRes = connData.openSQL(sql);
				if (oRes.moveNext()) {
					String sObligatorio = oRes.getString(sBuscarSituacion);
					String valorint = getItem(ITEMS.txtvalorint1).getValue();
					String valordecimal = getItem(ITEMS.txtvalordecimal1).getValue();
					String valortexto = getItem(ITEMS.txtvalortexto1).getValue();
					String valorlista = getItem(ITEMS.txtvalorlista1).getValue();
					String valorPasa = getItem(ITEMS.txtvalorpasa1).getValue();

					if (sObligatorio.equals("-1")) {
						if ((valorint == null || valorint.equals(""))
								&& (valordecimal == null || valordecimal.equals(""))
								&& (valortexto == null || valortexto.equals(""))
								&& (valorPasa == null || valorPasa.equals(""))
								&& (valorlista == null || valorlista.equals(""))) {
							String sMensaje = "El campo " + sCaracteristica + " debe estar relleno!";
							fmObject.showMessageText(sMensaje, "Aceptar");
							fmEvent.cancel();
						}
					}
				}
				oRes.close();
			}
		}

	}

	@Override
	public void containerActivate(FMEvent fmEvent) throws OTException {
		// TODO Auto-generated method stub
		super.containerActivate(fmEvent);
		String sViewName = fmEvent.getSourceName();
		if (sViewName.equals("duplicarValores")) {
			String sArticulo = getItem(ITEMS.txtequivalente_id).getValue();
			FMCombo fmCombo5 = (FMCombo) getView(VIEWS.txtsituacionorigen);
			fmCombo5.setSystemList(null);
			fmCombo5.clearItems();
			FMCombo fmCombo6 = (FMCombo) getView(VIEWS.txtsituaciondestino);
			fmCombo6.setSystemList(null);
			fmCombo6.clearItems();

			String sqlCombo = "select distinct xsituacion_dsp from " + connSdic.translateTable("s_art_carac")
					+ " where xarticulo_id='" + sArticulo + "'";
			oRes = connData.openSQL(sqlCombo);
			int iEstados = 0;
			// En función del número de estados encontrados hacemos visible los combos
			while (oRes.moveNext()) {
				String sSituacion = oRes.getString("xsituacion_dsp");
				switch (sSituacion) {
				// Si encontramos en la consulta el estado comprobamos si
				// ya estaban usandolos con el valor estático para ponerle el valor al combo
				case "0":
					fmCombo5.addItem("0-Basica");
					fmCombo6.addItem("0-Basica");
					break;
				case "2":
					fmCombo5.addItem("2-Muestra");
					fmCombo6.addItem("2-Muestra");
					break;
				case "4":
					fmCombo5.addItem("4-Massproduction");
					fmCombo6.addItem("4-Massproduction");
					break;
				case "6":
					fmCombo5.addItem("6-Comercial");
					fmCombo6.addItem("6-Comercial");
					break;
				case "8":
					fmCombo5.addItem("8-Inspeccion");
					fmCombo6.addItem("8-Inspeccion");
				}
				iEstados++;
			}
			oRes.close();
		}
	}

	@Override
	public void formItemSelect(FMEvent fmEvent) throws OTException {
		// TODO Auto-generated method stub
		super.formItemSelect(fmEvent);
		fmEvent.setRecall(true);
		String sViewName = fmEvent.getSourceName();
		ApartadoEnum[] apartados = ApartadoEnum.values();

		// Refrescamos los campos de cada columna con los datos seleccionados.
		if (sViewName.equals("txtcolumnaestado1")) {

			String situacion = getView(VIEWS.txtcolumnaestado1).getValue();
			if (!(situacion == null || situacion.equals(""))) {
				String[] datos = situacion.split("-");
				situacionColumna1 = (datos[0] + "#" + datos[1] + "Valores");
				for (int i = 0; i < apartados.length; i++) {
					getView(VIEWS.valueOf("txtvalormaestro_" + apartados[i].nombreValor))
							.setCaption(datos[0] + "#" + datos[1] + "Valores");
				}
			}
			String situacion2 = getItem(ITEMS.txtcolumnaestado2).getValue();
			if (!(situacion2 == null || situacion2.equals(""))) {
				String[] datos2 = situacion2.split("-");
				situacionColumna2 = (datos2[0] + "#" + datos2[1] + "Valores");

			}
			String situacion3 = getItem(ITEMS.txtcolumnaestado3).getValue();
			if (!(situacion3 == null || situacion3.equals(""))) {
				String[] datos3 = situacion3.split("-");
				situacionColumna3 = (datos3[0] + "#" + datos3[1] + "Valores");
			}
			String situacion4 = getItem(ITEMS.txtcolumnaestado4).getValue();
			if (!(situacion4 == null || situacion4.equals(""))) {
				String[] datos4 = situacion4.split("-");
				situacionColumna4 = (datos4[0] + "#" + datos4[1] + "Valores");
			}
			formReadRecord(fmEvent);

		} else if (sViewName.equals("txtcolumnaestado2")) {

			for (int i = 0; i < apartados.length; i++) {
				getView(VIEWS.valueOf("txtvalormaestro_" + apartados[i].nombreValor + "2")).setVisible(true);
			}

			String situacion = getView(VIEWS.txtcolumnaestado1).getValue();
			if (!(situacion == null || situacion.equals(""))) {
				String[] datos = situacion.split("-");
				situacionColumna1 = (datos[0] + "#" + datos[1] + "Valores");
			}
			String situacion2 = getItem(ITEMS.txtcolumnaestado2).getValue();
			if (!(situacion2 == null || situacion2.equals(""))) {
				String[] datos2 = situacion2.split("-");
				situacionColumna2 = (datos2[0] + "#" + datos2[1] + "Valores");
				for (int i = 0; i < apartados.length; i++) {
					getView(VIEWS.valueOf("txtvalormaestro_" + apartados[i].nombreValor + "2"))
							.setCaption(datos2[0] + "#" + datos2[1] + "Valores");
				}
			}
			String situacion3 = getItem(ITEMS.txtcolumnaestado3).getValue();
			if (!(situacion3 == null || situacion3.equals(""))) {
				String[] datos3 = situacion3.split("-");
				situacionColumna3 = (datos3[0] + "#" + datos3[1] + "Valores");
			}
			String situacion4 = getItem(ITEMS.txtcolumnaestado4).getValue();
			if (!(situacion4 == null || situacion4.equals(""))) {
				String[] datos4 = situacion4.split("-");
				situacionColumna4 = (datos4[0] + "#" + datos4[1] + "Valores");
			}
			formReadRecord(fmEvent);

		} else if (sViewName.equals("txtcolumnaestado3")) {

			String situacion = getView(VIEWS.txtcolumnaestado1).getValue();
			if (!(situacion == null || situacion.equals(""))) {
				String[] datos = situacion.split("-");
				situacionColumna1 = (datos[0] + "#" + datos[1] + "Valores");
			}
			String situacion2 = getItem(ITEMS.txtcolumnaestado2).getValue();
			if (!(situacion2 == null || situacion2.equals(""))) {
				String[] datos2 = situacion2.split("-");
				situacionColumna2 = (datos2[0] + "#" + datos2[1] + "Valores");

			}
			String situacion3 = getItem(ITEMS.txtcolumnaestado3).getValue();
			if (!(situacion3 == null || situacion3.equals(""))) {
				String[] datos3 = situacion3.split("-");
				situacionColumna3 = (datos3[0] + "#" + datos3[1] + "Valores");

				for (int i = 0; i < apartados.length; i++) {
					getView(VIEWS.valueOf("txtvalormaestro_" + apartados[i].nombreValor + "3"))
							.setCaption(datos3[0] + "#" + datos3[1] + "Valores");
				}
			}
			String situacion4 = getItem(ITEMS.txtcolumnaestado4).getValue();
			if (!(situacion4 == null || situacion4.equals(""))) {
				String[] datos4 = situacion4.split("-");
				situacionColumna4 = (datos4[0] + "#" + datos4[1] + "Valores");

			}
			formReadRecord(fmEvent);

		} else if (sViewName.equals("txtcolumnaestado4")) {

			String situacion = getView(VIEWS.txtcolumnaestado1).getValue();
			if (!(situacion == null || situacion.equals(""))) {
				String[] datos = situacion.split("-");
				situacionColumna1 = (datos[0] + "#" + datos[1] + "Valores");
			}
			String situacion2 = getItem(ITEMS.txtcolumnaestado2).getValue();
			if (!(situacion2 == null || situacion2.equals(""))) {
				String[] datos2 = situacion2.split("-");
				situacionColumna2 = (datos2[0] + "#" + datos2[1] + "Valores");

			}
			String situacion3 = getItem(ITEMS.txtcolumnaestado3).getValue();
			if (!(situacion3 == null || situacion3.equals(""))) {
				String[] datos3 = situacion3.split("-");
				situacionColumna3 = (datos3[0] + "#" + datos3[1] + "Valores");
			}
			String situacion4 = getItem(ITEMS.txtcolumnaestado4).getValue();
			if (!(situacion4 == null || situacion4.equals(""))) {
				String[] datos4 = situacion4.split("-");
				situacionColumna4 = (datos4[0] + "#" + datos4[1] + "Valores");
				for (int i = 0; i < apartados.length; i++) {
					getView(VIEWS.valueOf("txtvalormaestro_" + apartados[i].nombreValor + "4"))
							.setCaption(datos4[0] + "#" + datos4[1] + "Valores");
				}
			}
			formReadRecord(fmEvent);

		} else if (sViewName.equals("checknopasa")) {
			String sNopasa = getView(VIEWS.checknopasa).getValue();
			if (sNopasa.equals("-1")) {
				getItem(ITEMS.txtvalorpasa1).setValue(0);
			}
		} else if (sViewName.equals("txtvalorpasa1")) {
			String sPasa = getView(VIEWS.txtvalorpasa1).getValue();
			if (sPasa.equals("-1")) {
				getView(VIEWS.checknopasa).setValue(0);
			}
		}
	}

	public void viewChange(FMEvent oEvent) throws OTException {
		super.viewChange(oEvent);
		oEvent.setRecall(true);

		String sViewName = oEvent.getSourceName();
		OTVariant vValues = oEvent.getValues();
		char Num;
		String sCaracFinal = "";
		String sCaracteristica = "";

		String sNombreCol = sViewName.substring(16, sViewName.length());
		String[] sFinal = sNombreCol.split("_");
		if (sFinal.length > 1) {
			Num = sFinal[1].charAt(sFinal[1].length() - 1);
			sCaracFinal = sFinal[1];
		} else {
			Num = sFinal[0].charAt(sFinal[0].length() - 1);
			sCaracFinal = sFinal[0];
		}
		switch (Num) {
		case '2':
			sCaracFinal = sCaracFinal.substring(0, sCaracFinal.length() - 1);
			break;
		case '3':
			sCaracFinal = sCaracFinal.substring(0, sCaracFinal.length() - 1);
			break;
		case '4':
			sCaracFinal = sCaracFinal.substring(0, sCaracFinal.length() - 1);
			break;
		}
		if (sCaracFinal.equals("inf") || sCaracFinal.equals("chec")) {
			sCaracFinal = sCaracFinal.substring(0, sCaracFinal.length() - 1);
		}
		if (sViewName.equals("txtvalormaestro_" + sNombreCol)) {
			String sEstado = getView(VIEWS.valueOf("txtvalormaestro_" + sNombreCol)).getCaption();
			if (sFinal.length > 1) {
				sCaracteristica = getItem(ITEMS.valueOf("txtcaracteristica_" + sFinal[0] + "_" + sCaracFinal))
						.getValue();
			} else {
				sCaracteristica = getItem(ITEMS.valueOf("txtcaracteristica_" + sCaracFinal)).getValue();
			}
			String[] datos = sEstado.split("#");
			if (comprobarObligatorio(sCaracteristica, datos[0])) {
				vValues.setValue(0, new OTVariant(5034100)); // Verde

			} else {
				vValues.setValue(0, new OTVariant(15066597)); // Gris
			}

		}
		oEvent.setViewChangeValues(vValues);
	}

	@Override
	public void formLoad(FMEvent fmEvent) throws OTException {
		// TODO Auto-generated method stub
		super.formPostLoad(fmEvent);
		fmEvent.setRecall(true);
		descripcion = "";

		getView(VIEWS.txtvalorint1).setViewChangeEvent(true);
		getView(VIEWS.txtvalorint2).setViewChangeEvent(true);
		getView(VIEWS.txtvalorint3).setViewChangeEvent(true);
		getView(VIEWS.txtvalorint4).setViewChangeEvent(true);
		getView(VIEWS.txtvalorint5).setViewChangeEvent(true);
		getView(VIEWS.txtvalorint6).setViewChangeEvent(true);
		getView(VIEWS.txtvalordecimal1).setViewChangeEvent(true);
		getView(VIEWS.txtvalordecimal2).setViewChangeEvent(true);
		getView(VIEWS.txtvalordecimal3).setViewChangeEvent(true);
		getView(VIEWS.txtvalordecimal4).setViewChangeEvent(true);
		getView(VIEWS.txtvalordecimal5).setViewChangeEvent(true);
		getView(VIEWS.txtvalordecimal6).setViewChangeEvent(true);

		ApartadoEnum[] apartados = ApartadoEnum.values();
		for (int i = 0; i < apartados.length; i++) {
			getView(VIEWS.valueOf("txtvalormaestro_" + apartados[i].nombreValor)).setViewChangeEvent(true);
			getView(VIEWS.valueOf("txtvalormaestro_" + apartados[i].nombreValor + "2")).setViewChangeEvent(true);
			getView(VIEWS.valueOf("txtvalormaestro_" + apartados[i].nombreValor + "3")).setViewChangeEvent(true);
			getView(VIEWS.valueOf("txtvalormaestro_" + apartados[i].nombreValor + "4")).setViewChangeEvent(true);
		}
	}

	@Override
	public void formPostLoad(FMEvent fmEvent) throws OTException {
		// TODO Auto-generated method stub
		super.formPostLoad(fmEvent);

		connSdic = session.getConnectionSource();
		connData = session.getConnectionData();
		String sArticulo = getItem(ITEMS.txtequivalente_id).getValue();
		String sEmpresa = getItem(ITEMS.txtempresa_id).getValue();

		String sql = "select top 1 xcantidad_desde,xincoterm,xpuerto_salida,xdivisa_id,puerto.xnombre from "
				+ connSdic.translateTable("adv_precios_prov") + " prov inner join "
				+ connSdic.translateTable("adv_puertos") + " puerto on prov.xpuerto_salida= puerto.xpuerto_id"
				+ " where xempresa_id='" + sEmpresa + "' and xarticulo_id='" + sArticulo + "' order by xfecha desc";
		oRes = connData.openSQL(sql);
		if (oRes.moveNext()) {
			int iMOQ = oRes.getInt("xcantidad_desde");
			String sIncoterm = oRes.getString("xincoterm");
			String sPuerto = oRes.getString("xpuerto_salida");
			String sNombrePuerto = oRes.getString("xnombre");
			String sDivisa = oRes.getString("xdivisa_id");

			getItem(ITEMS.txtmqo).setValue(iMOQ);
			getItem(ITEMS.txtincoterm).setValue(sIncoterm);
			getItem(ITEMS.txtpuerto).setValue(sPuerto);
			getItem(ITEMS.txtpuerto).setDescription(sNombrePuerto);
			getItem(ITEMS.txtdivisa).setValue(sDivisa);

		}
		oRes.close();
	}

	public boolean comprobarObligatorio(String sCaracteristica, String sEstado) {
		boolean obligatorio = false;
		String sCampo = "";
		String sSituacion = "";
		connSdic = session.getConnectionSource();
		try {
			connData = session.getConnectionData();

			switch (sEstado) {
			case "0":
				sCampo = "xbasicaobliga";
				break;
			case "2":
				sCampo = "xinspeccionobliga";
				break;
			case "4":
				sCampo = "xmuestraobliga";
				break;
			case "6":
				sCampo = "xmassobliga";
				break;
			case "8":
				sCampo = "xcomercialobliga";
				break;

			}
			if (!(sCampo == null || sCampo.equals("") || sCampo.equals("null"))) {
				String sql = "select " + sCampo + " from " + connSdic.translateTable("s_caracteristicas")
						+ " where xcaracteristica_id='" + sCaracteristica + "'";

				oRes = connData.openSQL(sql);
				if (oRes.moveNext()) {
					sSituacion = oRes.getString(sCampo);
				}
				oRes.close();
				if (sSituacion.equals("-1")) {
					obligatorio = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obligatorio;
	}

	@Override
	public void formItemValidate(FMEvent fmEvent) throws OTException {
		// TODO Auto-generated method stub
		super.formItemValidate(fmEvent);
		fmEvent.setRecall(true);
		String sViewName = fmEvent.getSourceName();
		if (sViewName.contains("txtfoto")) {
			byte[] fotoActual = getItem(ITEMS.valueOf(sViewName)).getValue().getBytes();
			byte[] fotoOriginal = getItem(ITEMS.valueOf(sViewName)).getOriginalValue().getBytes();
			if (!fotoActual.equals(fotoOriginal)) {
				byte[] fotoinsert = getItem(ITEMS.valueOf(sViewName)).getValueBytes();
				String sArticulo = getItem(ITEMS.txtequivalente_id).getValue();
				String imagenBase = Base64.getEncoder()
						.encodeToString(getItem(ITEMS.valueOf(sViewName)).getValueBytes());
				// //String encoding = Base64.encodeBase64(userPassword.getBytes());
				String sNombre = getView(VIEWS.valueOf(sViewName)).getParent();
				String[] separarDatos = sNombre.split("_");
				String sApartado = separarDatos[1];
				try {
					String sql = "update " + connSdic.translateTable("s_imagenes_dsp") + " set ximagen='" + imagenBase
							+ "' where xarticulo_id='" + sArticulo + "'and xapartado_id='" + sApartado + "'";
					int i = connData.execSQL(sql);
					if (i == 0) {
						sql = "insert into " + connSdic.translateTable("s_imagenes_dsp") + " values('" + sArticulo
								+ "','" + imagenBase + "','" + sApartado + "')";
						connData.execSQL(sql);
					}
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		}else if (sViewName.contains("txtarticulo_id")) {
			getItem(ITEMS.txtequivalente_id).setValue("");
		}
		controlarTabulaciones(sViewName);
		comprobarProgramacion(sViewName);
	}

	private void comprobarProgramacion(String sViewName) {
		String sTipo = sViewName.substring(8, sViewName.length() - 1);
		String sNumero = sViewName.substring(sViewName.length() - 1, sViewName.length());

		if (sViewName.equals("txtvalor" + sTipo + sNumero)) {
			String sValor = getItem(ITEMS.valueOf("txtvalor" + sTipo + sNumero)).getValue();
			String sOperador = getItem(ITEMS.txtoperador).getValue();
			if (!(getItem(ITEMS.txtvalorprog1).getValue() == null
					|| getItem(ITEMS.txtvalorprog1).getValue().equals(""))) {
				switch (sTipo) {
				case "int":
					if (!(sValor == null || sValor.equals(""))) {
						int iValor = Integer.parseInt(sValor);
						if (sOperador.equals("0")) {
							int iValorOP1 = Integer.parseInt(getItem(ITEMS.txtvalorprog1).getValue());
							int iValorOP2 = Integer.parseInt(getItem(ITEMS.txtvalorprog2).getValue());
							if (!(iValor > iValorOP1 && iValor < iValorOP2)) {
//								getView(VIEWS.valueOf("lblmensaje" + sNumero)).setValue(
//										"El Valor de " + getItem(ITEMS.valueOf("txtnombre" + sNumero)).getValue()
//												+ " debe ser entre " + iValorOP1 + " y " + iValorOP2);
							} else {
//								getView(VIEWS.valueOf("lblmensaje" + sNumero)).setValue("");
							}
						} else if (sOperador.equals("1")) {
							int iValorOP1 = Integer.parseInt(getItem(ITEMS.txtvalorprog1).getValue());
							if (!(iValor > iValorOP1)) {
//								getView(VIEWS.valueOf("lblmensaje" + sNumero)).setValue(
//										"El Valor de " + getItem(ITEMS.valueOf("txtnombre" + sNumero)).getValue()
//												+ " debe ser mayor de " + iValorOP1);
							} else {
//								getView(VIEWS.valueOf("lblmensaje" + sNumero)).setValue("");
							}
						} else if (sOperador.equals("2")) {
							int iValorOP1 = Integer.parseInt(getItem(ITEMS.txtvalorprog1).getValue());
							if (!(iValor < iValorOP1)) {
//								getView(VIEWS.valueOf("lblmensaje" + sNumero)).setValue(
//										"El Valor de " + getItem(ITEMS.valueOf("txtnombre" + sNumero)).getValue()
//												+ " debe ser menor de " + iValorOP1);
							} else {
//								getView(VIEWS.valueOf("lblmensaje" + sNumero)).setValue("");
							}
						}
					}
					break;
				case "decimal":
					if (!(sValor == null || sValor.equals(""))) {
						BigDecimal bValor = new BigDecimal(sValor);
						if (sOperador.equals("0")) {
							BigDecimal bValorOP1 = new BigDecimal(getItem(ITEMS.txtvalorprog1).getValue());
							BigDecimal bValorOP2 = new BigDecimal(getItem(ITEMS.txtvalorprog2).getValue());
							if (!(bValor.compareTo(bValorOP1) == 1 && bValor.compareTo(bValorOP2) == -1)) {
//								getView(VIEWS.valueOf("lblmensaje" + sNumero)).setValue(
//										"El Valor de " + getItem(ITEMS.valueOf("txtnombre" + sNumero)).getValue()
//												+ " debe ser entre " + bValorOP1 + " y " + bValorOP2);
							} else {
//								getView(VIEWS.valueOf("lblmensaje" + sNumero)).setValue("");
							}
						} else if (sOperador.equals("1")) {
							BigDecimal bValorOP1 = new BigDecimal(getItem(ITEMS.txtvalorprog1).getValue());
							if (!(bValor.compareTo(bValorOP1) == 1)) {
//								getView(VIEWS.valueOf("lblmensaje" + sNumero)).setValue(
//										"El Valor de " + getItem(ITEMS.valueOf("txtnombre" + sNumero)).getValue()
//												+ " debe ser mayor de " + bValorOP1);
							} else {
//								getView(VIEWS.valueOf("lblmensaje" + sNumero)).setValue("");
							}
						} else if (sOperador.equals("2")) {
							BigDecimal bValorOP1 = new BigDecimal(getItem(ITEMS.txtvalorprog1).getValue());
							if (!(bValor.compareTo(bValorOP1) == -1)) {
//								getView(VIEWS.valueOf("lblmensaje" + sNumero)).setValue(
//										"El Valor de " + getItem(ITEMS.valueOf("txtnombre" + sNumero)).getValue()
//												+ " debe ser menor de " + bValorOP1);
							} else {
//								getView(VIEWS.valueOf("lblmensaje" + sNumero)).setValue("");
							}
						}
					}
					break;
				}
			}
		}
	}

	@Override
	public void preOpenForm(FMEvent fmEvent) throws OTException {
		// TODO Auto-generated method stub
		super.preOpenForm(fmEvent);
		fmEvent.setRecall(true);
		situacionColumna1 = "";
		situacionColumna2 = "";
		situacionColumna3 = "";
		situacionColumna4 = "";
	}

	private void buscarDescripcion() {
		ApartadoEnum[] apartados = ApartadoEnum.values();
		String auxDescripcion = getView(VIEWS.auxdescripcion).getValue().toUpperCase();
		int iLineas = 0;
		boolean encontrado = false;
		String[] paneles = new String[apartados.length];
		String[] descripcionPanel = new String[apartados.length];
		for (int i = 0; i < apartados.length; i++) {
			paneles[i] = "grd_" + apartados[i].id;
			descripcionPanel[i] = "txtcaracteristica_" + apartados[i].caracteristicaValor;
		}
		
		if (!(descripcion.equals(auxDescripcion))) {
			descripcion = auxDescripcion;
			for (int i = 0; i < paneles.length; i++) {
				FMGrid grid = (FMGrid) fmObject.getContainer(paneles[i]);
				iLineas = grid.getRows();
				grid.setRowColor(grid.getCurrentRow(), new Color(229, 229, 229), null);
				if (encontrado == false) {
					for (int p = 0; p < iLineas; p++) {
						String sDescripcion = getItem(ITEMS.valueOf(descripcionPanel[i])).getDescription(p)
								.toUpperCase();
						if (sDescripcion.contains(auxDescripcion)) {
							grid.setCurrentRow(p);
							
							String datosGrid[] = paneles[i].split("_");
							String collapsible = "collap_" + datosGrid[1];
							grid.setRowColor(p, Color.YELLOW, null);
							encontrado = true;
							break;
						}
					}
				}
			}
		} else {
			descripcion = auxDescripcion;
			for (int i = 0; i < paneles.length; i++) {
				FMGrid grid = (FMGrid) fmObject.getContainer(paneles[i]);
				iLineas = grid.getRows();
				grid.setRowColor(grid.getCurrentRow(), new Color(229, 229, 229), null);
				if (encontrado == false) {
					for (int p = grid.getCurrentRow() + 1; p < iLineas; p++) {
						String sDescripcion = getItem(ITEMS.valueOf(descripcionPanel[i])).getDescription(p)
								.toUpperCase();
						if (sDescripcion.contains(auxDescripcion)) {
							grid.setCurrentRow(p);
							grid.setRowColor(p, Color.YELLOW, null);
							String datosGrid[] = paneles[i].split("_");
							String collapsible = "collap_" + datosGrid[1];
							getContainer(CONTAINERS.valueOf(collapsible)).setSize(100, 100);
							encontrado = true;
							break;
						}
					}
				}
			}
		}
	}

	public void createSystemList(String listName, String[] codes, String[] values) {
		ArrayList<SystemListElement> elements = new ArrayList<SystemListElement>();
		for (int i = 0; i < codes.length; i++) {
			SystemListElement itemList = new SystemListElement();
			itemList.code = codes[i];
			try {
				MultiLingual mlg = new MultiLingual(boObject.getSession());
				mlg.addText(boObject.getSession().getLanguageCode(), values[i]);
				itemList.mlgValue = mlg;
			} catch (Exception e) {
			}
			elements.add(itemList);
		}
		SystemList.add(boObject.getSession(), listName, elements);
	}

	public void controlarTabulaciones(String sViewName) {
//		String sValor = sViewName.substring(3, 8);
//		if (sValor.equals("valor")) {
//			int iNumero = Integer.parseInt(sViewName.substring(sViewName.length() - 1, sViewName.length()));
//			String sItem = sViewName.substring(0, sViewName.length() - 1);
//			if (sItem.equals("txtvalorlista")) {
//				getView(VIEWS.cmdaceptar).setFocus();
//				return;
//			}
//			if (sItem.equals("txtvalorpasa")) {
//				getView(VIEWS.cmdaceptar).setFocus();
//				return;
//			}
//			if (iNumero == 6) {
//				getView(VIEWS.cmdaceptar).setFocus();
//			} else {
//				String sNombre = getItem(ITEMS.valueOf("txtnombre" + (iNumero + 1))).getValue();
//				if (!(sNombre == null || sNombre.equals(""))) {
//					getView(VIEWS.valueOf(sItem + (iNumero + 1))).setFocus();
//				} else {
//					getView(VIEWS.cmdaceptar).setFocus();
//				}
//			}
//		}
	}

	public static void programarCaracteristicas(Session session, String sArticulo, String sEstado) {
		DAConnectionSource connSdic = session.getConnectionSource();
		DAConnection connData;
		try {
			connData = session.getConnectionData();
			// TK014
			String sql = "update imp.s_art_carac set xvalordecimal1=(((select cast(isnull(xvalorint1,0) as decimal) from imp.s_art_carac where xcaracteristica_id='TK013' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "') "
					+ "/(select cast(isnull(xvalorint1,1) as decimal) from imp.s_art_carac where xcaracteristica_id='TK012' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'))*100)"
					+ " where xcaracteristica_id='TK014' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"
					+ sArticulo + "';";
			// TK021
			sql += " update imp.s_art_carac set xvalordecimal1=("
					+ "((select cast(isnull(xvalorint1,0) as decimal) from imp.s_art_carac where xcaracteristica_id='TK016' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ "+(select cast(isnull(xvalorint1,0)  as decimal) from imp.s_art_carac where xcaracteristica_id='TK018' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ "+(select cast(isnull(xvalorint1,0)  as decimal) from imp.s_art_carac where xcaracteristica_id='TK020' and xsituacion_dsp='"
					+ sEstado + "' " + "and xarticulo_id='" + sArticulo + "'))"
					+ "/(select cast(isnull(xvalorint1,1)  as decimal) from imp.s_art_carac where xcaracteristica_id='TK011' and xsituacion_dsp='"
					+ sEstado + "' " + "and xarticulo_id='" + sArticulo + "'))*100"
					+ " where xcaracteristica_id='TK021' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"
					+ sArticulo + "';";
			// TK022
			sql += "update imp.s_art_carac set xvalorlista1= case "
					+ " when((select cast(xvalorint1 as decimal) from imp.s_art_carac where xcaracteristica_id='TK016' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " >(select cast(xvalorint1 as decimal) from imp.s_art_carac where xcaracteristica_id='TK015' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')) then 2"
					+ " when((select cast(xvalorint1 as decimal) from imp.s_art_carac where xcaracteristica_id='TK018' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " >(select cast(xvalorint1 as decimal) from imp.s_art_carac where xcaracteristica_id='TK017' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')) then 2"
					+ " when((select cast(xvalorint1 as decimal) from imp.s_art_carac where xcaracteristica_id='TK020' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " >(select cast(xvalorint1 as decimal) from imp.s_art_carac where xcaracteristica_id='TK019' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')) then 2"
					+ " else 1 end  where xcaracteristica_id='TK022' and xsituacion_dsp='" + sEstado
					+ "' and xarticulo_id='" + sArticulo + "';";

			// SM053 xvalordecimal2
			sql += " update imp.s_art_carac set xvalordecimal2=(1+(1-"
					+ " ((select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " /(select isnull(xvalordecimal1,1) from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'))))"
					+ " *(select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='SM053' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " where xcaracteristica_id='SM053' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"
					+ sArticulo + "';";
			// SM062 xvalordecimal3
			sql += " update imp.s_art_carac set xvalordecimal3=(1+(1-"
					+ " ((select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " /(select isnull(xvalordecimal1,1) from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'))))"
					+ " *(select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='SM062' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " where xcaracteristica_id='SM062' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"
					+ sArticulo + "';";
			// SM062 xvalordecimal4
			sql += " update imp.s_art_carac set xvalordecimal4=(1+(1-"
					+ " ((select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " /(select isnull(xvalordecimal1,1) from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'))))"
					+ " *(select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='SM062' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " where xcaracteristica_id='SM062' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"
					+ sArticulo + "';";
			// SM071 xvalordecimal4
			sql += " update imp.s_art_carac set xvalordecimal4=(1+(1-"
					+ " ((select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " /(select isnull(xvalordecimal1,1) from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'))))"
					+ " *(select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='SM071' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " where xcaracteristica_id='SM071' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"
					+ sArticulo + "';";
			// SM071 xvalordecimal5
			sql += " update imp.s_art_carac set xvalordecimal5=(1+(1-"
					+ " ((select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " /(select isnull(xvalordecimal1,1) from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'))))"
					+ " *(select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='SM071' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " where xcaracteristica_id='SM071' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"
					+ sArticulo + "';";
			// SM071 xvalordecimal6
			sql += " update imp.s_art_carac set xvalordecimal6=(1+(1-"
					+ " ((select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " /(select isnull(xvalordecimal1,1) from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'))))"
					+ " *(select xvalordecimal3 from imp.s_art_carac where xcaracteristica_id='SM071' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " where xcaracteristica_id='SM071' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"
					+ sArticulo + "';";
			// SM080 xvalordecimal4
			sql += " update imp.s_art_carac set xvalordecimal4=(1+(1-"
					+ " ((select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " /(select isnull(xvalordecimal1,1) from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'))))"
					+ " *(select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='SM080' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " where xcaracteristica_id='SM080' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"
					+ sArticulo + "';";
			// SM080 xvalordecimal5
			sql += " update imp.s_art_carac set xvalordecimal5=(1+(1-"
					+ " ((select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " /(select isnull(xvalordecimal1,1) from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'))))"
					+ " *(select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='SM080' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " where xcaracteristica_id='SM080' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"
					+ sArticulo + "';";
			// SM080 xvalordecimal6
			sql += " update imp.s_art_carac set xvalordecimal6=(1+(1-"
					+ " ((select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " /(select isnull(xvalordecimal1,1) from imp.s_art_carac where xcaracteristica_id='LM004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'))))"
					+ " *(select xvalordecimal3 from imp.s_art_carac where xcaracteristica_id='SM080' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " where xcaracteristica_id='SM080' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"
					+ sArticulo + "';";
			// LM017
			sql += " update imp.s_art_carac set xvalorlista1= "
					+ "case when (select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='LM011' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')>=120 then 1 else 2 end"
					+ " where xarticulo_id='" + sArticulo + "' and xsituacion_dsp='" + sEstado
					+ "' and xcaracteristica_id='LM017';";
			// LM019
			sql += " update imp.s_art_carac set xvalorlista1= "
					+ "case when (select xvalorlista1 from imp.s_art_carac where xcaracteristica_id='GD004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')=1 then 1 else 2 end " + "where xarticulo_id='"
					+ sArticulo + "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM019';";
			// LM020
			sql += " update imp.s_art_carac set xvalorlista1= "
					+ " case when (select xvalorlista1 from imp.s_art_carac where xcaracteristica_id='CL001' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "') in ('11','10','9') then 2"
					+ " when (select xvalorlista1 from imp.s_art_carac where xcaracteristica_id='CL002' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "') in ('" + sEstado + "','5') then 2"
					+ " else 1 end where xarticulo_id='" + sArticulo + "' and xsituacion_dsp='" + sEstado
					+ "' and xcaracteristica_id='LM020';";
			// LM021
			sql += " update imp.s_art_carac set xvalorlista1= "
					+ " case when (select xvalorlista1 from imp.s_art_carac where xcaracteristica_id='LM006' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "') in ('4','6','8','14') then 2"
					+ " when (select xvalorlista1 from imp.s_art_carac where xcaracteristica_id='LM008' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "') in  ('4','6','8','14') then 2"
					+ " else 1 end where xarticulo_id='" + sArticulo + "' and xsituacion_dsp='" + sEstado
					+ "' and xcaracteristica_id='LM021';";
			// LM023
			sql += " update imp.s_art_carac set xvalorlista1= "
					+ "case when (select xvalorlista1 from imp.s_art_carac where xcaracteristica_id='CO042' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')=8 then 2 else 1 end" + " where xarticulo_id='"
					+ sArticulo + "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM023';";
			// LM030
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='SM081' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM030';";
			// LM031
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='SM081' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM031';";
			// LM025
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='GD009' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM025';";
			// LM026
			sql += " update imp.s_art_carac set xvalorlista1= "
					+ "(select xvalorlista1 from imp.s_art_carac where xcaracteristica_id='GD010' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM026';";
			
			// LM032
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal3 from imp.s_art_carac where xcaracteristica_id='SM081' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM032';";
			// LM036
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='DI005' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM036';";
			// LM037
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='DI003' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM037';";
			// LM038
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='DI004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM038';";
			// LM041
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='SM085' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM041';";
			// LM043
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='SM085' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM043';";
			// LM044
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal3 from imp.s_art_carac where xcaracteristica_id='SM085' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM044';";
			// LM045
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='SM086' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM045';";
			// LM046
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='SM086' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM046';";
			// LM047
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal3 from imp.s_art_carac where xcaracteristica_id='SM086' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM047';";
			// LM048
			sql += " update imp.s_art_carac set xvalordecimal1=( "
					+ "(select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='LM027' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ "/(select isnull(xvalordecimal1,1) from imp.s_art_carac where xcaracteristica_id='LM011' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'))" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM048';";
			// LM049
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='LM011' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM049';";
			// LM052
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='SM087' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM052';";
			// LM053
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='SM087' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM053';";
			// LM054
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal3 from imp.s_art_carac where xcaracteristica_id='SM087' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM054';";
			// LM057
			sql += "update imp.s_art_carac set xvalordecimal1="
					+ " (select isnull(xvalordecimal1,(select case when isnull(xvalordecimal1,0)>=isnull(xvalordecimal2,0) then"
					+ " isnull(xvalordecimal1,(select case when isnull(xvalordecimal1,0)>=isnull(xvalordecimal2,0) and  isnull(xvalordecimal1,0)>=isnull(xvalordecimal3,0)then"
					+ " isnull(xvalordecimal1,(select case when isnull(xvalordecimal1,0)>=isnull(xvalordecimal2,0) and  isnull(xvalordecimal1,0)>=isnull(xvalordecimal3,0)then"
					+ " isnull(xvalordecimal1,0)"
					+ " when isnull(xvalordecimal2,0)>=isnull(xvalordecimal1,0) and  isnull(xvalordecimal2,0)>=isnull(xvalordecimal3,0)then xvalordecimal2"
					+ " else xvalordecimal3 "
					+ " end from imp.s_art_carac where xcaracteristica_id='SM083' and xsituacion_dsp='" + sEstado
					+ "' and xarticulo_id='" + sArticulo + "'))"
					+ " when isnull(xvalordecimal2,0)>=isnull(xvalordecimal1,0) and  isnull(xvalordecimal2,0)>=isnull(xvalordecimal3,0)then xvalordecimal2"
					+ " else xvalordecimal3 "
					+ " end from imp.s_art_carac where xcaracteristica_id='SM074' and xsituacion_dsp='" + sEstado
					+ "' and xarticulo_id='" + sArticulo + "'))" + " else xvalordecimal2 "
					+ " end from imp.s_art_carac where xcaracteristica_id='SM065' and xsituacion_dsp='" + sEstado
					+ "' and xarticulo_id='" + sArticulo + "'))"
					+ " from imp.s_art_carac where xcaracteristica_id='SM056' and xsituacion_dsp='" + sEstado
					+ "' and xarticulo_id='" + sArticulo + "') where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM057';";
			// LM058
			sql += " update imp.s_art_carac set xvalordecimal1="
					+ " (select isnull(xvalordecimal1,(select case when isnull(xvalordecimal1,0)>=isnull(xvalordecimal2,0) then"
					+ " isnull(xvalordecimal1,(select case when isnull(xvalordecimal1,0)>=isnull(xvalordecimal2,0) and  isnull(xvalordecimal1,0)>=isnull(xvalordecimal3,0)then"
					+ " isnull(xvalordecimal1,(select case when isnull(xvalordecimal1,0)>=isnull(xvalordecimal2,0) and  isnull(xvalordecimal1,0)>=isnull(xvalordecimal3,0)then"
					+ " isnull(xvalordecimal1,0)"
					+ " when isnull(xvalordecimal2,0)>=isnull(xvalordecimal1,0) and  isnull(xvalordecimal2,0)>=isnull(xvalordecimal3,0)then xvalordecimal2"
					+ " else xvalordecimal3 "
					+ " end from imp.s_art_carac where xcaracteristica_id='SM084' and xsituacion_dsp='" + sEstado
					+ "' and xarticulo_id='" + sArticulo + "'))"
					+ " when isnull(xvalordecimal2,0)>=isnull(xvalordecimal1,0) and  isnull(xvalordecimal2,0)>=isnull(xvalordecimal3,0)then xvalordecimal2"
					+ " else xvalordecimal3 "
					+ " end from imp.s_art_carac where xcaracteristica_id='SM075' and xsituacion_dsp='" + sEstado
					+ "' and xarticulo_id='" + sArticulo + "'))" + " else xvalordecimal2 "
					+ " end from imp.s_art_carac where xcaracteristica_id='SM066' and xsituacion_dsp='" + sEstado
					+ "' and xarticulo_id='" + sArticulo + "'))"
					+ " from imp.s_art_carac where xcaracteristica_id='SM057' and xsituacion_dsp='" + sEstado
					+ "' and xarticulo_id='" + sArticulo + "') where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM058';";
			// LM059
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal2 from imp.s_art_carac where xcaracteristica_id='SM084' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM059';";
			// LM060
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal3 from imp.s_art_carac where xcaracteristica_id='SM084' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM060';";
			// LM033
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ "(select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='SM052' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM033';";
			// FN007
			sql += " update imp.s_art_carac set xvalordecimal1=(select isnull(xvalordecimal1,0)*60 from imp.s_art_carac where xcaracteristica_id='FN006' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),"
					+ " xvalordecimal2=(select isnull(xvalordecimal2,0)*60 from imp.s_art_carac where xcaracteristica_id='FN006' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),"
					+ " xvalordecimal3=(select isnull(xvalordecimal3,0)*60 from imp.s_art_carac where xcaracteristica_id='FN006' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),"
					+ " xvalordecimal4=(select isnull(xvalordecimal4,0)*60 from imp.s_art_carac where xcaracteristica_id='FN006' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),"
					+ " xvalordecimal5=(select isnull(xvalordecimal5,0)*60 from imp.s_art_carac where xcaracteristica_id='FN006' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),"
					+ " xvalordecimal6=(select isnull(xvalordecimal6,0)*60 from imp.s_art_carac where xcaracteristica_id='FN006' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='FN007';";
			// FN009
			sql += " update imp.s_art_carac set"
					+ " xvalordecimal1=(select isnull(xvalordecimal1,0)/(select isnull(xvalordecimal1,0) from imp.s_art_carac where xcaracteristica_id='FN004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo
					+ "')from imp.s_art_carac where xcaracteristica_id='FN006' and xsituacion_dsp='" + sEstado
					+ "' and xarticulo_id='" + sArticulo + "'),"
					+ " xvalordecimal2=(select isnull(xvalordecimal2,0)/(select isnull(xvalordecimal2,0) from imp.s_art_carac where xcaracteristica_id='FN004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo
					+ "') from imp.s_art_carac where xcaracteristica_id='FN006' and xsituacion_dsp='" + sEstado
					+ "' and xarticulo_id='" + sArticulo + "'),"
					+ " xvalordecimal3=(select isnull(xvalordecimal3,0)/(select isnull(xvalordecimal3,0) from imp.s_art_carac where xcaracteristica_id='FN004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo
					+ "') from imp.s_art_carac where xcaracteristica_id='FN006' and xsituacion_dsp='" + sEstado
					+ "' and xarticulo_id='" + sArticulo + "'),"
					+ " xvalordecimal4=(select isnull(xvalordecimal4,0)/(select isnull(xvalordecimal4,0) from imp.s_art_carac where xcaracteristica_id='FN004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo
					+ "') from imp.s_art_carac where xcaracteristica_id='FN006' and xsituacion_dsp='" + sEstado
					+ "' and xarticulo_id='" + sArticulo + "'),"
					+ " xvalordecimal5=(select isnull(xvalordecimal5,0)/(select isnull(xvalordecimal5,0) from imp.s_art_carac where xcaracteristica_id='FN004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo
					+ "') from imp.s_art_carac where xcaracteristica_id='FN006' and xsituacion_dsp='" + sEstado
					+ "' and xarticulo_id='" + sArticulo + "'),"
					+ " xvalordecimal6=(select isnull(xvalordecimal6,0)/(select isnull(xvalordecimal6,0) from imp.s_art_carac where xcaracteristica_id='FN004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo
					+ "') from imp.s_art_carac where xcaracteristica_id='FN006' and xsituacion_dsp='" + sEstado
					+ "' and xarticulo_id='" + sArticulo + "')" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='FN009';";
			// LM029
			sql += " update imp.s_art_carac set xvalorlista1=(select case when xvalorlista1 IN('1','2','3')then 1 "
					+ " when  xvalorlista1 IN('8')then 2  when  xvalorlista1 in ('4','6') "
					+ "then 3 else null end  from imp.s_art_carac where xcaracteristica_id='LM006' "
					+ "and xsituacion_dsp='" + sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ "where xcaracteristica_id='LM029' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"
					+ sArticulo + "';";
			// LM042
			sql += " update imp.s_art_carac set xvalorlista1=(select xvalorlista1 from imp.s_art_carac where xcaracteristica_id='PI12'"
					+ " and xsituacion_dsp='" + sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ "where xcaracteristica_id='LM042' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"+ sArticulo + "';";
			// LM028
			sql += " update imp.s_art_carac set xvalorlista1=(select xvalorlista1 from imp.s_art_carac where xcaracteristica_id='LM003' "
					+ " and xsituacion_dsp='" + sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ "where xcaracteristica_id='LM028' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"+ sArticulo + "';";
			// LM018
			sql += " update imp.s_art_carac set xvalorlista1=(select isnull(xvalorlista1,(select xvalorlista1 from imp.s_art_carac where xcaracteristica_id='HS001' and xarticulo_id='"+sArticulo+"' and xsituacion_dsp='"+sEstado+"')) from imp.s_art_carac where xcaracteristica_id='HM001' "
					+ " and xsituacion_dsp='" + sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ "where xcaracteristica_id='LM018' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"+ sArticulo + "';";
			// LM024
			sql += " update imp.s_art_carac set xvalorlista1=(select case when xvalorlista1 IN('9','10')then 1 "
					+ "when  xvalorlista1 IN('2','3','4','5','6','7','8')then 2  when  xvalorlista1='1' "
					+ "then 3 else null end  from imp.s_art_carac where xcaracteristica_id='DM004' "
					+ "and xsituacion_dsp='" + sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ "where xcaracteristica_id='LM024' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"
					+ sArticulo + "';";
			// LM027
			sql += " update imp.s_art_carac set xvalordecimal1= "
					+ " (select case when isnull(xvalordecimal1,0)>=isnull(xvalordecimal2,0) then "
					+ " isnull(xvalordecimal1 ,(select case when isnull(xvalordecimal1,0)>=isnull(xvalordecimal2,0) and isnull(xvalordecimal1,0)>=isnull(xvalordecimal3,0) "
					+ " and isnull(xvalordecimal1,0)>=isnull(xvalordecimal4,0) then "
					+ " isnull(xvalordecimal1,(select case when isnull(xvalordecimal1,0)>=isnull(xvalordecimal2,0) and isnull(xvalordecimal1,0)>=isnull(xvalordecimal3,0) "
					+ " and isnull(xvalordecimal1,0)>=isnull(xvalordecimal4,0) then "
					+ " isnull(xvalordecimal1,(select case when isnull(xvalordecimal1,0)>=isnull(xvalordecimal2,0) and isnull(xvalordecimal1,0)>=isnull(xvalordecimal3,0) "
					+ " and isnull(xvalordecimal1,0)>=isnull(xvalordecimal4,0) and isnull(xvalordecimal1,0)>=isnull(xvalordecimal5,0)and isnull(xvalordecimal1,0)>=isnull(xvalordecimal6,0) then "
					+ " xvalordecimal1 "
					+ " when isnull(xvalordecimal2,0)>=isnull(xvalordecimal1,0) and isnull(xvalordecimal2,0)>=isnull(xvalordecimal3,0) "
					+ " and isnull(xvalordecimal2,0)>=isnull(xvalordecimal4,0) and isnull(xvalordecimal2,0)>=isnull(xvalordecimal5,0)and isnull(xvalordecimal2,0)>=isnull(xvalordecimal6,0) then "
					+ " xvalordecimal2  "
					+ " when isnull(xvalordecimal3,0)>=isnull(xvalordecimal1,0) and isnull(xvalordecimal3,0)>=isnull(xvalordecimal2,0) "
					+ " and isnull(xvalordecimal3,0)>=isnull(xvalordecimal4,0)  and isnull(xvalordecimal3,0)>=isnull(xvalordecimal5,0)and isnull(xvalordecimal3,0)>=isnull(xvalordecimal6,0)then "
					+ " xvalordecimal3 "
					+ " when isnull(xvalordecimal4,0)>=isnull(xvalordecimal1,0) and isnull(xvalordecimal4,0)>=isnull(xvalordecimal2,0) "
					+ " and isnull(xvalordecimal4,0)>=isnull(xvalordecimal3,0)  and isnull(xvalordecimal4,0)>=isnull(xvalordecimal5,0)and isnull(xvalordecimal4,0)>=isnull(xvalordecimal6,0)then "
					+ " xvalordecimal4  "
					+ " when isnull(xvalordecimal5,0)>=isnull(xvalordecimal1,0) and isnull(xvalordecimal5,0)>=isnull(xvalordecimal2,0) "
					+ " and isnull(xvalordecimal5,0)>=isnull(xvalordecimal3,0)  and isnull(xvalordecimal5,0)>=isnull(xvalordecimal4,0)and isnull(xvalordecimal5,0)>=isnull(xvalordecimal6,0)then "
					+ " xvalordecimal5 "
					+ " else xvalordecimal6 end from imp.s_art_carac where xcaracteristica_id='SM080' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')) "
					+ " when isnull(xvalordecimal2,0)>=isnull(xvalordecimal1,0) and isnull(xvalordecimal2,0)>=isnull(xvalordecimal3,0) "
					+ " and isnull(xvalordecimal2,0)>=isnull(xvalordecimal4,0) then " + " xvalordecimal2  " + " else "
					+ " xvalordecimal3  end from imp.s_art_carac where xcaracteristica_id='SM072' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')) "
					+ " when isnull(xvalordecimal2,0)>=isnull(xvalordecimal1,0) and isnull(xvalordecimal2,0)>=isnull(xvalordecimal3,0) "
					+ " and isnull(xvalordecimal2,0)>=isnull(xvalordecimal4,0) then " + " xvalordecimal2  "
					+ " when isnull(xvalordecimal3,0)>=isnull(xvalordecimal1,0) and isnull(xvalordecimal3,0)>=isnull(xvalordecimal2,0) "
					+ " and isnull(xvalordecimal3,0)>=isnull(xvalordecimal4,0) then " + " xvalordecimal3 "
					+ " else xvalordecimal4 end from imp.s_art_carac where xcaracteristica_id='SM062' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')) "
					+ " else xvalordecimal2 end from imp.s_art_carac where xcaracteristica_id='SM053' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "') " + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM027';";

			// LM056
			sql += " update imp.s_art_carac set xvalordecimal1= ( POWER(2.71828,((LOG(0.7) * 3000) / (select isnull(xvalordecimal1,1) from imp.s_art_carac  where xcaracteristica_id='LM009' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'))) * 100)" + " where xarticulo_id='" + sArticulo
					+ "' and xsituacion_dsp='" + sEstado + "' and xcaracteristica_id='LM056';";
			// GD008
			sql += "update imp.s_art_carac set xvalordecimal1= isnull((select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='SM052' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),0)"
					+ " +isnull((select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='SM061' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),0)"
					+ " +isnull((select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='SM070' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),0)"
					+ " +isnull((select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='SM079' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),0)"
					+ " +isnull((select cast(isnull(xvalordecimal6,isnull(xvalordecimal5,isnull(xvalordecimal4,isnull(xvalordecimal3,isnull(xvalordecimal2,isnull(xvalordecimal1,0)))))) as decimal) from imp.s_art_carac where xcaracteristica_id='FN004' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),0)"
					+ " +isnull((select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='SK001' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),0)"
					+ " +isnull((select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='SP001' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),0)"
					+ " +isnull((select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='CP001' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),0)"
					+ " +isnull((select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='CP001' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),0)"
					+ " +isnull((select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='CG001' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),0)"
					+ " +isnull((select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='HT001' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),0)"
					+ " +isnull((select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='BR001' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),0)"
					+ " +isnull((select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='IZ001' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),0)"
					+ " +isnull((select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='CA001' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "'),0)"
					+ " where xcaracteristica_id='GD008' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"
					+ sArticulo + "';";
			// GD009
			sql += " update imp.s_art_carac set xvalordecimal1="
					+ " (select xvalordecimal1 from imp.s_art_carac where xcaracteristica_id='GD008' and xsituacion_dsp='"
					+ sEstado + "' and xarticulo_id='" + sArticulo + "')"
					+ " where xcaracteristica_id='GD009' and xsituacion_dsp='" + sEstado + "' and xarticulo_id='"
					+ sArticulo + "';";
			// Ejecutamos todos los updates de una sola vez para minimizar tiempos
			connData.execSQL(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void recolocarVentanaDatos(FMWindow oWindow, CONTAINERS contenedor) {

		String sNombre1 = getItem(ITEMS.txtnombre1).getValue();
		String sNombre2 = getItem(ITEMS.txtnombre2).getValue();
		String sNombre3 = getItem(ITEMS.txtnombre3).getValue();
		String sNombre4 = getItem(ITEMS.txtnombre4).getValue();
		String sNombre5 = getItem(ITEMS.txtnombre5).getValue();
		String sNombre6 = getItem(ITEMS.txtnombre6).getValue();
		String sNombre7 = getItem(ITEMS.txtnombre7).getValue();
		String sNombre8 = getItem(ITEMS.txtnombre8).getValue();
		String sNombre9 = getItem(ITEMS.txtnombre9).getValue();
		String sNombre10 = getItem(ITEMS.txtnombre10).getValue();
		getContainer(contenedor).setTop(0);

		// 1 label
		if ((!(sNombre1 == null || sNombre1.equals(""))) && (sNombre2 == null || sNombre2.equals(""))) {
			getContainer(contenedor).setHeight(58);
		}
		// 2 labels
		if ((!(sNombre2 == null || sNombre2.equals(""))) && (sNombre3 == null || sNombre3.equals(""))) {
			getContainer(contenedor).setHeight(88);
		}
		// 3 labels
		if ((!(sNombre3 == null || sNombre3.equals(""))) && (sNombre4 == null || sNombre4.equals(""))) {
			getContainer(contenedor).setHeight(110);
		}
		// 4 labels
		if ((!(sNombre4 == null || sNombre4.equals(""))) && (sNombre5 == null || sNombre5.equals(""))) {
			getContainer(contenedor).setHeight(128);
		}
		// 5 labels
		if ((!(sNombre5 == null || sNombre5.equals(""))) && (sNombre6 == null || sNombre6.equals(""))) {
			getContainer(contenedor).setHeight(178);
		}
		// 6 labels
		if ((!(sNombre6 == null || sNombre6.equals(""))) && (sNombre7 == null || sNombre7.equals(""))) {
			getContainer(contenedor).setHeight(194);
		}
		// 7 labels
		if ((!(sNombre7 == null || sNombre7.equals(""))) && (sNombre8 == null || sNombre8.equals(""))) {
			getContainer(contenedor).setHeight(238);
		}
		// 8 labels
		if ((!(sNombre8 == null || sNombre8.equals(""))) && (sNombre9 == null || sNombre9.equals(""))) {
			getContainer(contenedor).setHeight(268);
		}
		// 9 labels
		if ((!(sNombre9 == null || sNombre9.equals(""))) && (sNombre10 == null || sNombre10.equals(""))) {
			getContainer(contenedor).setHeight(298);
		}
		// 10 labels
		if (!(sNombre10 == null || sNombre10.equals(""))) {
			getContainer(contenedor).setHeight(328);
		}
		int iLocalizacion = getContainer(contenedor).getTop() + getContainer(contenedor).getHeight();
		getContainer(CONTAINERS.frcuerpo).setLocation(iLocalizacion, 0);
		int iAltoVentana = getContainer(CONTAINERS.frcuerpo).getTop() + getContainer(CONTAINERS.frcuerpo).getHeight();
		oWindow.setHeight(iAltoVentana);
	}

	public static enum ApartadoEnum {

		Apart_01("01", "Product_Information", "prod_inf", "prod_in", 0, "pnl_apart_prod_inf", false),
		Apart_02("02", "Certificates", "certif", "certif", 0, "pnl_apart_certif", false),
		Apart_03("03", "Packaging", "pack", "pack", 0, "pnl_apart_pack", false),
		Apart_04("04", "Components", "comp", "comp", 0, "pnl_apart_componentes", false),
		Apart_05("05", "Product_technical_data", "gen", "gen", 0, "pnl_apart_general", false),
		Apart_06("06", "Led_data", "led", "led", 0, "pnl_apart_led", false),
		Apart_07("07", "Led_Main", "ledmain", "ledmain", 0, "pnl_apart_ledmain", false),
		Apart_08("08", "Driver", "driver", "driver", 0, "pnl_apart_driver", false),
		Apart_09("09", "Control", "control", "control", 0, "pnl_apart_control", false),
		Apart_10("10", "Fan", "fan", "fan", 0, "pnl_apart_fan", false),
		Apart_11("11", "Dimensions", "dimen", "dimen", 0, "pnl_apart_dimension", false),
		Apart_12("12", "Remote_control_work", "remote", "remote", 0, "pnl_apart_remote", false),
		Apart_13("13", "Work_test", "test", "test", 0, "pnl_apart_test", false),
		Apart_14("14", "Datos_chequeo", "dat_chec", "dat_che", 0, "pnl_apart_dat_chec", false),
		Apart_15("15", "AQL", "aql", "aql", 0, "pnl_apart_aql", false),
		Apart_16("16", "Cuerpo_carcasa", "ccar", "ccar", 0, "pnl_apart_ccar", false),
		Apart_17("17", "Palas", "pala", "pala", 0, "pnl_apart_pala", false),
		Apart_18("18", "Plato_luz", "plat", "plat", 0, "pnl_apart_plat", false),
		Apart_19("19", "Difusor", "dif", "dif", 0, "pnl_apart_dif", false),
		Apart_20("20", "Embellecedor_superior", "embs", "embs", 0, "pnl_apart_embs", false),
		Apart_21("21", "Embellecedor_inferior", "embi", "embi", 0, "pnl_apart_embi", false),
		Apart_22("22", "Tija_bola", "tibo", "tibo", 0, "pnl_apart_tibo", false),
		Apart_23("23", "Tija", "tija", "tija", 0, "pnl_apart_tija", false),
		Apart_24("24", "Tulipa", "tuli", "tuli", 0, "pnl_apart_tuli", false),
		Apart_25("25", "Base", "base", "base", 0, "pnl_apart_base", false),
		Apart_26("26", "Floron", "flor", "flor", 0, "pnl_apart_flor", false),
		Apart_27("27", "Embellecedor", "embe", "embe", 0, "pnl_apart_embe", false),
		Apart_28("28", "Aro", "aro", "aro", 0, "pnl_apart_aro", false),
		Apart_29("29", "Cable", "cabl", "cabl", 0, "pnl_apart_cabl", false),
		Apart_30("30", "Reflector", "refl", "refl", 0, "pnl_apart_refl", false),
		Apart_31("31", "Lente", "lent", "lent", 0, "pnl_apart_lent", false),
		Apart_32("32", "Test components", "tcomp", "tcomp", 0, "pnl_apart_tcompo", false),
		Apart_33("33", "Emb.sup.motor", "esm", "esm", 0, "pnl_apart_esm", false),
		Apart_34("34", "Emb.inf.motor", "eim", "eim", 0, "pnl_apart_eim", false),
		Apart_35("35", "Lamp_holder", "lamp", "lamp", 0, "pnl_apart_lamp", false),
		Apart_38("38", "IOT", "iot", "iot", 0, "pnl_apart_iot", false),
		Apart_39("39", "Sensor", "sens", "sens", 0, "pnl_apart_sens", false),
		Apart_40("40", "Battery", "bate", "bate", 0, "pnl_apart_bate", false),
		Apart_41("41", "Speaker", "spe", "spe", 0, "pnl_apart_spe", false),
		Apart_42("42", "Spray_humidifier", "spr", "spr", 0, "pnl_apart_spr", false),
		Apart_43("43", "Ceiling_projector", "ceil", "ceil", 0, "pnl_apart_ceil", false),
		Apart_44("44", "Rotating_grill", "gril", "gril", 0, "pnl_apart_gril", false),
		Apart_45("45", "Particle_filter", "part", "part", 0, "pnl_apart_part", false),
		Apart_46("46", "Heated_blades", "blad", "blad", 0, "pnl_apart_blad", false),
		Apart_47("47", "Blades_raxis", "raxi", "raxi", 0, "pnl_apart_raxi", false),
		Apart_48("48", "Ionizer", "ioni", "ioni", 0, "pnl_apart_ioni", false),
		Apart_49("49", "Camera", "came", "came", 0, "pnl_apart_came", false),
		Apart_50("50", "Assembly", "asse", "asse", 0, "pnl_apart_asse", false),
		Apart_52("52", "App_Android", "appa", "appa", 0, "pnl_apart_appa", false),
		Apart_53("53", "App_IOS", "appi", "appi", 0, "pnl_apart_appi", false),
		Apart_54("54", "Alexa_Android", "alex", "alex", 0, "pnl_apart_alex", false),
		Apart_55("55", "Alexa_iOS", "alei", "alei", 0, "pnl_apart_alei", false),
		Apart_56("56", "Google_android", "goga", "goga", 0, "pnl_apart_goga", false),
		Apart_57("57", "Google_iOS", "gogi", "gogi", 0, "pnl_apart_gogi", false),
		Apart_58("58", "EPREL", "eprl", "eprl", 0, "pnl_apart_eprl", false),
		Apart_59("59", "Test_destructivos", "tdes", "tdes", 0, "pnl_apart_tdes", false),
		Apart_60("60", "Bracket", "brac", "brac", 0, "pnl_apart_brac", false),
		Apart_61("61", "Luz_principal", "lprin", "lprin", 0, "pnl_apart_lprin", false),
		Apart_63("63", "Luz_secundaria", "lsec", "lsec", 0, "pnl_apart_lsec", false);

		public String id;
		public String apartado;
		public String nombreValor;
		public String caracteristicaValor;
		public int contador;
		public String segment;
		public boolean imagenInsertada;

		private ApartadoEnum(String id, String apartado, String nombreValor, String caracteristicaValor, int contador,
				String segment, boolean imagenInsertada) {
			this.id = id;
			this.apartado = apartado;
			this.nombreValor = nombreValor;
			this.caracteristicaValor = caracteristicaValor;
			this.contador = contador;
			this.segment = segment;
			this.imagenInsertada = imagenInsertada;
		}

		public String getId() {
			return id;
		}

		public boolean isImagenInsertada() {
			return imagenInsertada;
		}

		public void setImagenInsertada(boolean imagenInsertada) {
			this.imagenInsertada = imagenInsertada;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getSegment() {
			return segment;
		}

		public void setSegment(String segment) {
			this.segment = segment;
		}

		public String getApartado() {
			return apartado;
		}

		public void setApartado(String apartado) {
			this.apartado = apartado;
		}

		public String getNombreValor() {
			return nombreValor;
		}

		public void setNombreValor(String nombreValor) {
			this.nombreValor = nombreValor;
		}

		public String getCaracteristicaValor() {
			return caracteristicaValor;
		}

		public void setCaracteristicaValor(String caracteristicaValor) {
			this.caracteristicaValor = caracteristicaValor;
		}

		public int getContador() {
			return contador;
		}

		public void setContador(int contador) {
			this.contador = contador;
		}

	}
}
