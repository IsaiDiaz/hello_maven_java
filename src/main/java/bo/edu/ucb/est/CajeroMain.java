package bo.edu.ucb.est;

public class CajeroMain {
    public static void main (String[]args){
        Cuenta[] cuentasC1={new Cuenta(111122,"Bolivianos","Caja de Ahorros",12000),new Cuenta(112211,"USD","Cuenta Corriente",100)};
        Cliente c1=new Cliente("Juan Perez","jperez",3333,cuentasC1);
        Cuenta[] cuentasC2={new Cuenta(221122,"Bolivianos","Caja de Ahorros",0)};
        Cliente c2=new Cliente("Maria Gomez","mgomez",4444,cuentasC2);
        Cuenta[] cuentasC3={new Cuenta(331122,"Bolivianos","Caja de Ahorros",100),new Cuenta(332211,"USD","Cuenta Corriente",1000),new Cuenta(332233,"Bolivianos","Caja de Ahorros",100000)};
        Cliente c3=new Cliente("Jose Perez","jperez",2222, cuentasC3);
        Cliente[] clientes={c1,c2,c3};
        Sesion sesion=new Sesion(clientes);
        sesion.inicioSesion();
    }
}

