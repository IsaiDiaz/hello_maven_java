package bo.edu.ucb.est;

public class Cuenta {
    private int nroCuenta;
    private String tipoMoneda;
    private String tipo;
    private double saldo;

    public Cuenta(int nroCuenta, String tipoMoneda, String tipo, double saldo) {
        this.nroCuenta = nroCuenta;
        this.tipoMoneda = tipoMoneda;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public String getTipo() {
        return tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void deposito(double monto){
        setSaldo(getSaldo()+monto);
    }

    public void retiro(double monto){
        setSaldo(getSaldo()-monto);
    }
}
