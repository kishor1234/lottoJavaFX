/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.invoice;

import javax.print.DocPrintJob;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

/**
 *
 * @author asksoft
 */
final class PrintJobWatcher {

    PrintJobWatcher(DocPrintJob job) {
        setPrintJob(job);
    }

    public void setPrintJob(DocPrintJob job) {
        // Add a listener to the print job
        job.addPrintJobListener(
                new PrintJobAdapter() {
                    public void printJobCanceled(PrintJobEvent printJobEvent) {
                        allDone();
                    }

                    public void printJobCompleted(PrintJobEvent printJobEvent) {
                        allDone();
                    }

                    public void printJobFailed(PrintJobEvent printJobEvent) {
                        allDone();
                    }

                    public void printJobNoMoreEvents(PrintJobEvent printJobEvent) {
                        allDone();
                    }

                    void allDone() {
                        synchronized (PrintJobWatcher.this) {
                            boolean done = true;
                            PrintJobWatcher.this.notify();
                        }
                    }
                });
    }
}
