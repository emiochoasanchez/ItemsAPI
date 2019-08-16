
public class Header {
    private String Parametro;
    private String Valor;

    public Header() {
    }

    public Header(String parametro, String valor) {
        Parametro = parametro;
        Valor = valor;
    }

    public String getParametro() {
        return Parametro;
    }

    public void setParametro(String parametro) {
        Parametro = parametro;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }
}