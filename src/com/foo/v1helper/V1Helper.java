/**
 * 
 */
package com.foo.v1helper;

import com.versionone.Oid;
import com.versionone.apiclient.*; 



/**
 * @author jeff
 *
 */
public class V1Helper 
{
	private static EnvironmentContext _context;
	private static IMetaModel _metaModel;
	private static IServices _services;
	private static V1Configuration _config;
	
	/**
	 * 
	 */
	public V1Helper() throws Exception 
	{
	 
	}
	
	public Asset singleAsset(String assetId) throws Exception 
	{
		Oid memberId = Oid.fromToken(assetId, _metaModel);
		Query query = new Query(memberId);
		QueryResult result = _services.retrieve(query);
		Asset member = result.getAssets()[0];
		System.out.println(member.getOid().getToken());
		return member;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try
		{
			V1Helper viHelper = new V1Helper(); 
			//V1Configuration configuration = 
				//new V1Configuration(new V1APIConnector("https://v1.corp.integragroup.com/v1sdktesting/config.v1/"));
			
			V1APIConnector dataConnector = new V1APIConnector("https://www12.v1host.com/7thAxisLLC/rest-1.v1/Data", "jeff", "123123");
			V1APIConnector metaConnector = new V1APIConnector("https://www12.v1host.com/7thAxisLLC/meta.v1/");
			_metaModel = new MetaModel(metaConnector);
			_services = new Services(_metaModel, dataConnector);
			
			Asset asset = viHelper.singleAsset("Story:1005");
			
		}
		catch (Exception e)
		{
			System.err.println("Exception in main(): "+e);
			System.exit(1); 
		}
		
		
		
		
		
	}

}
