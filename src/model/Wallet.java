package model;

public class Wallet {

    public static final int LIMITE_BILLETERA = 500000;

    /**
     * saldo de la billetera
     */ 
    private int saldo;
    private boolean tieneLimite;

    private int meta;
    
    public Wallet(boolean limite) {
        super();
        saldo = 0;
        tieneLimite = limite;
    }

    public int getSaldo(){
        return saldo;
    }

    public String putSaldo(int valor){
        if(saldo + valor > LIMITE_BILLETERA && tieneLimite){
            return "No puede superar el limite";
        }
        saldo += valor;
        return "Operación exitosa, nuevo saldo " + saldo;
    }

    public String getMoney(int valor) {
        // if(valor > saldo){
        //     return "Saldo insuficiente";
        // }
        if(valor > saldo){
            int saldoTemp = saldo;
            saldo = 0;
            return "Solo se retiró " + saldoTemp;
        }
        saldo -= valor;
        return "Retiro exitoso, nuevo saldo " + saldo;
    }
//codigo que compartio un compañero

    public String breakLimit(){
        if (!tieneLimite){
            return "Error. Su cuenta es sin límites";
        }
        if (saldo < 10000){
            return "Error. Romper el limite tiene un costo de 10000, usted tiene " + saldo;
        }
        saldo -= 10000;
        tieneLimite = false;
        return "Operación exitosa. Su cuenta ahora es sin límites, nuevo saldo: " + saldo;
    }

    public String definirMeta(int valor){
        if (valor > LIMITE_BILLETERA && tieneLimite){
            return "Ops, te has pasado del límite permitido";
        }
        if (valor <= 0){
            return "El valor indicado no es válido";
        }
        if (valor <= saldo){
            return "Ya has cumplido esta meta";
        }
        meta = valor;
            return " Meta agregada ";
        }
         
    }
    public boolean verificarMeta(){
        if (saldo >= meta && meta > 0){
            return true;
        }
        return false
    }


}
