package com.cub.ao.asset.test;

import jdk.nashorn.api.scripting.AbstractJSObject;

public class AssetSummaryServiceImplTest  {/*

	@Autowired
	private AssetSummaryService assetSummaryService;
	private List<CasaSummaryVO> expCasaResult;
	private List<DepositSummaryVO> expDepositResult;
	private List<CasaTransactionVO> expCasaTxnResult;
	private String customerId = "1234568";
	private String accountNo = "0000110312345671";


	@Before
	public void initInputs() throws Exception {
		System.out.println("initInputs");
		System.out.println(assetSummaryService);
		expCasaResult = assetSummaryService.getCaSaSummary(customerId);
		expDepositResult = assetSummaryService.getDepositSummary(customerId);
		expCasaTxnResult = assetSummaryService.getCaSaTransaction(accountNo);
	}
	*//**
	 * Test case for checking the customer id is not null;
	 *//*
	@Test
	public void testCustomerId() {
		System.out.println("testCustomerId");
		assertNotNull(customerId);
	}

	
	*//**
	 * Test case for checking getCasaSummary
	 * @throws Exception
	 *//*
	 
	@Test
	public void testGetCasaSummary() throws Exception {

		System.out.println("testGetCasaSummary");

		List<CasaSummaryVO> result = assetSummaryService.getCaSaSummary(customerId);

		assertEquals("expected list size doesnot match: ", expCasaResult.size(),
				result.size());
		assertEquals("expected account no doesn't match", expCasaResult.get(0).getAccountNumber(),
				result.get(0).getAccountNumber());
		
	}
	
	*//**
	 * Test case for checking getDepositSummary
	 * @throws Exception
	 *//*
 	 
	@Test
	public void testGetDepositSummary() throws Exception {

		System.out.println("testGetDepositSummary");

		List<DepositSummaryVO> result = assetSummaryService.getDepositSummary(customerId);

		assertEquals("expected list size doesnot match: ", expDepositResult.size(),
				result.size());
		assertEquals("expected account no doesn't match", expDepositResult.get(0).getAccountNumber(),
				result.get(0).getAccountNumber());
		
	}
	
	*//**
	 * Test case for checking getCasaTransaction
	 * @throws Exception
	 *//*
		 
	@Test
	public void testGetCasaTransaction() throws Exception {

		System.out.println("testGetCasaTransaction");

		List<CasaTransactionVO> result = assetSummaryService.getCaSaTransaction(accountNo);

		assertEquals("expected list size doesnot match: ", expCasaTxnResult.size(),
				result.size());
		assertEquals("expected account no doesn't match", expCasaTxnResult.get(0).getAccountBalance(),
				result.get(0).getAccountBalance());
		
	}
*/}
