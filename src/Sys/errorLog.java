/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys;

import Sys.api.httpAPI;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asksoft
 */
public class errorLog {

    public errorLog() {

    }

    public void write(Exception e) {
        System.out.println(e.getMessage());
    }

}
