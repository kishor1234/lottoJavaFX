/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.Sereis;

/**
 *
 * @author asksoft
 */
public class Series {

    public String id;
    public String series;
    

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeries() {
        return this.series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
   

    @Override
    public String toString() {
        return getId()+""+getSeries();
    }
}
