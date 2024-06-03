
package gimnasiogrupo10;

import gimnasiogrupo10.AccesoADatos.*;
import gimnasiogrupo10.entidades.*;
import javax.swing.JOptionPane;

public class GimnasioGrupo10 {

    public static void main(String[] args) {
        // Prueba SocioData
        
       // Socios Juan=new Socios (132456,"Juan Pablo","Rodriguez",21,"Juanpa.r@gmail.com","2664112233",true);
      //  SocioData socio=new SocioData();
        //socio.guardarSocio(Juan);

        
//        Socios socioEncontrado=socio.buscarSocio(2);  //para buscar por dni solo hay que cambiar el metodo al que se invoca.
//        if(socioEncontrado !=null){
//            System.out.println(socioEncontrado.toString());
//        }else{
//            JOptionPane.showMessageDialog(null, "La Id ingresada no corresponde a un socio");
//        }

        SocioData scs=new SocioData();
        
        for(Socios socios:scs.listarSocios()){
            System.out.println(socios.toString());
        }

    }  
}
