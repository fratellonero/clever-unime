/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.clever.administration.api;

import java.util.ArrayList;
import java.util.List;
import org.clever.Common.Exceptions.CleverException;
import org.clever.Common.Shared.HostEntityInfo;
import org.clever.Common.XMPPCommunicator.ConnectionXMPP;


/**
 * Modulo per gestire le VM
 * @author maurizio
 */
public class VMAdministrationModule extends AdministrationModule{
    
    public VMAdministrationModule (Session s)
    {
        super(s);
       
    }
    
    /**
     * Lancia una VM direttamente dndo il comando ad un HOST
     * Da evitare: usare i metodi del CM
     * @return ClusterManager attivo
     */
    public boolean startVM_HOST(String host, String VMName) throws CleverException
    {
        
        Boolean returnResponse;
        ArrayList params = new ArrayList();
        params.add(VMName);
        returnResponse = ( Boolean ) 
                                this.execSyncCommand(
                                        host,
                                        "HyperVisorAgent",
                                        "startVm",
                                        params,
                                        false);
        return returnResponse;
    }
    
    /**
     * Lancia delle VMs direttamente dando il comando ad un HOST
     * Da evitare: usare i metodi del CM
     * @return ClusterManager attivo
     */
    public boolean startVMs_HOST(String host, String[] VMName) throws CleverException
    {
        
        Boolean returnResponse;
        ArrayList params = new ArrayList();
        params.add(VMName);
        returnResponse = ( Boolean ) 
                                this.execSyncCommand(
                                        host,
                                        "HyperVisorAgent",
                                        "startVm",
                                        params,
                                        false);
        return returnResponse;
    }
    
     
    
    
    
    
    /**
     * Ferma una VM direttamente dando il comando ad un HOST
     * Da evitare: usare i metodi del CM
     * @return ClusterManager attivo
     */
    public boolean stopVM_HOST(String host, String VMName, Boolean poweroff) throws CleverException
    {
        
        Boolean returnResponse;
        ArrayList params = new ArrayList();
        params.add(VMName);
        params.add(poweroff);
        returnResponse = ( Boolean ) 
                                this.execSyncCommand(
                                        host,
                                        "HyperVisorAgent",
                                        "shutDownVm",
                                        params,
                                        false);
        return returnResponse;
    }
    
    /**
     * Lista delle VM direttamente dando il comando ad un HOST
     * Da evitare: usare i metodi del CM
     * @return ClusterManager attivo
     */
    public List listVMs_HOST(String host, Boolean onlyrunning) throws CleverException
    {
        
        List returnResponse;
        String method;
        if(onlyrunning)
        {
            method="listRunningVms";
        }
        else
        {
            method="listVms";
        }
        returnResponse = ( List ) 
                                this.execSyncCommand(
                                        host,
                                        "HyperVisorAgent",
                                        method,
                                        this.emptyParams,
                                        false);
        return returnResponse;
    }
    
    
            
        
    
    
    
}