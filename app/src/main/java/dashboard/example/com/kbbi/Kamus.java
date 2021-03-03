package dashboard.example.com.kbbi;

import java.io.Serializable;
import java.util.List;

public class Kamus implements Serializable {
    private String lema;
    private List<String> arti;

    public Kamus(String lema, List<String> arti) {
        this.lema = lema;
        this.arti = arti;
    }

    public String getLema() {
        return lema;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

    public List<String> getArti() {
        return arti;
    }

    public void setArti(List<String> arti) {
        this.arti = arti;
    }
}
