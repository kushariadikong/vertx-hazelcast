/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pesan {
    private final String pesan;
    
    @JsonCreator
    public Pesan(@JsonProperty("pesan") String pesan){
        this.pesan = pesan;
    }
    
    @JsonProperty("pesan")
    public String getPesan(){
        return pesan;
    }
 }
