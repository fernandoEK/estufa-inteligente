package dispositivo;

public class Ventilador implements Controlavel {
    private boolean ligado;

    @Override
    public void ligar() {
        ligado = true;
    }

    @Override
    public void desligar() {
        ligado = false;
    }

    @Override
    public boolean verificarStatus() {
        return ligado;
    }

    @Override
    public String toString() {
        return ligado ? "Ventilador ligado" : "Ventilador desligado";
    }
}
