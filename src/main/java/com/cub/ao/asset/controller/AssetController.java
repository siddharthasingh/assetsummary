package com.cub.ao.asset.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cub.ao.asset.exception.RecordNotFoundException;
import com.cub.ao.asset.service.AssetSummaryService;
import com.cub.ao.asset.utility.AssetConstants;
import com.cub.ao.asset.vo.CasaSummaryVO;
import com.cub.ao.asset.vo.CasaTransactionVO;
import com.cub.ao.asset.vo.CombinedDepositSummaryResponse;
import com.cub.ao.asset.vo.CombinedDepositSummaryVO;
import com.cub.ao.asset.vo.DepositSummaryVO;
import com.cub.ao.asset.vo.ResponseMessageVo;
/**
 * This class is the main controller for AssetSummary micro service
 * It has operations to get Casa Summary or deposit summary for the given customerId and get Casa transaction details
 * for the given account no.
 *
 */
@RestController
@RequestMapping("/asset")
public class AssetController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AssetController.class);
	private static final String CLASS_NAME = AssetController.class.getName();
	@Autowired
	AssetSummaryService assetService;
	/**
	 * This operation gets the AssetCasa summary for the given customerId
	 * @param customerId
	 * @return List<CasaSummaryVO>
	 */
	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	@ResponseBody
	public List<CasaSummaryVO> getAssetCasaSummary(
			@RequestParam(value = "customerId", required = true) String customerId) {
		final String methodName = "getAssetCasaSummary";
		LOGGER.debug(AssetConstants.LOG_ENTER_METHOD + methodName + AssetConstants.LOG_OF_CLASS + CLASS_NAME);
		List<CasaSummaryVO> resp = new ArrayList<CasaSummaryVO>();

		if (!StringUtils.isEmpty(customerId)) {
			resp = assetService.getCaSaSummary(customerId);
		}
		LOGGER.debug(AssetConstants.LOG_EXIT_METHOD + methodName + AssetConstants.LOG_OF_CLASS + CLASS_NAME);
		return resp;
	}
	
	
	
}
