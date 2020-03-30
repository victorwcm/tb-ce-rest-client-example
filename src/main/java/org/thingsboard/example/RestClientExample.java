package org.thingsboard.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.thingsboard.rest.client.RestClient;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.device.DeviceSearchQuery;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.security.DeviceCredentials;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestClientExample {
    public static void main(String[] args) throws IOException {
        // ThingsBoard REST API URL
        String url = "http://localhost:9090";

        // Default Tenant Administrator credentials
        String username = "victor@jualabs.com";
        String password = "victor";

        // Creating new rest client and auth with credentials
        RestClient client = new RestClient(url);
        client.login(username, password);
        
        // creating the list of countries
        ArrayList<String> countries = new ArrayList<String>( 
        		Arrays.asList("Brasil"));
        // creating the list of regions
        ArrayList<String> regions = new ArrayList<String>( 
        		Arrays.asList("Norte","Nordeste","Sul","Sudeste","Centro-Oeste"));
        // creating the list of regions
        ArrayList<String> states = new ArrayList<String>( 
    		Arrays.asList("Pernambuco-PE", "Ceará-CE", "São Paulo-SP"));
        // creating the list of regions
        ArrayList<String> cities = new ArrayList<String>( 
    		Arrays.asList("Recife","Caruaru","Petrolina","Fortaleza","São Paulo"));
        // creating the list of regions
        ArrayList<String> districts = new ArrayList<String>( 
    		Arrays.asList("Boa Viagem","Ibura","Casa Amarela","Areia Branca", "Maurício de Nassau", "Mucuripe","Morumbi"));
        

        
    
       

        // Creating an Asset
        Asset asset = new Asset();
//        asset.setName("Predio 1");
//        asset.setType("predio");
//        asset = client.saveAsset(asset);

        // creating a Device
        Device device = new Device();
//        device.setName("Termometro 1");
//        device.setType("termometro");
//        device = client.saveDevice(device);
        DeviceSearchQuery query = new DeviceSearchQuery();
        
        device = client.getTenantDevice("C891").get();
        DeviceCredentials token = client.getDeviceCredentialsByDeviceId(device.getId()).get();
        System.out.println(token.getCredentialsId());
        
        String json = "{ \"chave\" : \"valor\" } ";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);        
        
        client.saveEntityTelemetry(device.getId(), "CLIENT_SCOPE", jsonNode);
        
        EntityRelation relation = new En
        
        client.saveRelation(relation);
        // creating relations from device to asset
//        EntityRelation relation = new EntityRelation();
//        relation.setFrom(asset.getId());
//        relation.setTo(device.getId());
//        relation.setType("Contains");
//        client.saveRelation(relation);

    }
}
