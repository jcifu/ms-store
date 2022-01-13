package com.jcifu.store.shoppingcart.client;

import java.net.URI;
import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

 @Component("ShoppingCartEurekaClient")
public class EurekaClient {
    
     @Autowired
     private DiscoveryClient discoveryClient;

     public URI getUri(String serviceName){
        
         List<ServiceInstance> list = discoveryClient.getInstances(serviceName);
          //Por ahora no hay balanceo de carga por ello se requiere la uri de la primera instancia de la lista de instancias del servicio
         if(list != null && list.size() > 0){
             return list.get(0).getUri();
         }
        
         return null;
     }
}
