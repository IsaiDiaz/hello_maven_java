package bo.edu.ucb.est;

import java.util.Scanner;

public class Cliente {
    private String nombre;
    private String codigo;
    private int PIN;
    private Cuenta[] cuentas;

    public Cliente (String nombre,String codigo,int PIN, Cuenta[] cuentas){
        this.nombre=nombre;
        this.codigo=codigo;
        this.PIN=PIN;
        this.cuentas=cuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getPIN() {
        return PIN;
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public boolean verificar(String codigo,int PIN){
        return codigo.equals(getCodigo()) && PIN == getPIN();
    }

    public int mostrarCuentas(){
        int s=-1;
        for(int i=0;i<cuentas.length;i++){
            System.out.println("Cuenta: "+(i+1));
        }
        System.out.print("Seleccione una cuenta: ");
        try{
            Scanner tc=new Scanner(System.in);
            s=tc.nextInt()-1;
        }catch (Exception e) {
            System.out.println("ERROR: "+e);
            mostrarCuentas();
        }
        return s;
    }
}
