package bo.edu.ucb.est;

import java.util.Scanner;

public class Sesion {
    private Cliente[] clientes;
    private int clienteActual;
    private Cuenta[] cuentas;

    public Sesion(Cliente[]clientes){
        this.clientes=clientes;
    }

    public void inicioSesion(){
        try {
            Scanner tc=new Scanner(System.in);
            String codigo = null;
            int PIN = -1;
            System.out.println("Ingrese su código y PIN");
            System.out.println("Código: ");
            codigo = tc.nextLine();
            System.out.println("PIN: ");
            PIN = tc.nextInt();
            boolean f = false;
            int i = 0;
            while (!f && i < clientes.length) {
                if (clientes[i].verificar(codigo, PIN)) {
                    clienteActual = i;
                    cuentas = clientes[i].getCuentas();
                    f = true;
                }
                i++;
            }
            if (f) {
                System.out.println("Bienvenid@ " + clientes[clienteActual].getNombre() + "\n\n");
                menu();
            } else {
                System.out.println("Datos incorrectos\n\n");
                inicioSesion();
            }
        }catch (Exception e){
            System.out.println("ERROR: "+e);
            inicioSesion();
        }
    }
    public void menu(){
        try {
            Scanner tc=new Scanner(System.in);
            System.out.println("Menú de Opciones:\n1: Ver Saldo\n2: Retirar dinero\n3: Depositar dinero\n4: Salir");
            System.out.print("Selección: ");
            int o = tc.nextInt();
            switch (o) {
                case 1:
                    verSaldo();
                    menu();
                    break;
                case 2:
                    retirarDinero();
                    menu();
                    break;
                case 3:
                    depositarDinero();
                    menu();
                    break;
                case 4:
                    inicioSesion();
                    break;
                default:
                    System.out.println("Valor incorrecto");
                    menu();
                    break;
            }
        }catch(Exception e){
            System.out.println("ERROR: "+e);
            menu();
        }
    }
    //System.out.println("Cuenta "+(i+1)+": \nNumero de Cuenta: "+cuentas[i].getNroCuenta()+"\nMoneda: "+cuentas[i].getTipoMoneda()+"\nTipo: "+cuentas[i].getTipo()+"\nSaldo: "+cuentas[i].getSaldo());
    public void verSaldo(){
        int c=clientes[clienteActual].mostrarCuentas();
        System.out.println("Cuenta "+(c+1)+": \nNúmero de Cuenta: "+cuentas[c].getNroCuenta()+"\nMoneda: "+cuentas[c].getTipoMoneda()+"\nTipo: "+cuentas[c].getTipo()+"\nSaldo: "+cuentas[c].getSaldo()+"\n\n");
    }
    public void retirarDinero(){
        Scanner tc=new Scanner(System.in);
        double retiro=0;
        int c=clientes[clienteActual].mostrarCuentas();
        System.out.println("Saldo Actual: "+cuentas[c].getSaldo()+" "+cuentas[c].getTipoMoneda());
        System.out.print("Saldo a retirar: ");
        try {
            retiro = tc.nextDouble();
            if(retiro<1 || retiro>cuentas[c].getSaldo()){
                System.out.println("Entrada invalida");
               menu();
            }
            System.out.println("\n\n");
            cuentas[c].retiro(retiro);
        }catch(Exception e){
            System.out.println("ERROR: "+e);
            menu();
        }
    }
    public void depositarDinero(){
        Scanner tc=new Scanner(System.in);
        double deposito=0;
        int c=clientes[clienteActual].mostrarCuentas();
        System.out.println("Saldo Actual: "+cuentas[c].getSaldo());
        System.out.print(cuentas[c].getTipoMoneda()+" a depositar: ");
        try {
            deposito = tc.nextDouble();
            if(deposito<1 ){
                System.out.println("Entrada invalida");
                menu();
            }
            System.out.println("\n\n");
            cuentas[c].deposito(deposito);
        }catch (Exception e){
            System.out.println("ERROR: "+e);
            menu();
        }
    }
}
