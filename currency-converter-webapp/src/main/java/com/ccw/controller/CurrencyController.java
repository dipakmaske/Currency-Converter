package com.ccw.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.ccw.pojos.Currency;
import com.ccw.pojos.History;
import com.ccw.service.CurrencyService;
import com.ccw.service.HistoryService;

@Controller
@RequestMapping("/currency")
public class CurrencyController {

	@Autowired
	CurrencyService curService;

	@Autowired
	HistoryService historyService;

	@Value("${api.key}")
	private String apiKey;

	@Value("${url}")
	private String url;

	@Autowired
	private RestTemplate restTemplate;

	public CurrencyController() {
		System.out.println("ctor" + getClass().getName());
	}

	@GetMapping
	public String showConvertorform(Currency c) {
		return "/main";
	}

	@PostMapping()
	public String processRegisterForm(Currency c, Model modelMap, HttpSession hs) {
		String jsonString = restTemplate.getForObject(
				url + c.getFrom() + "_" + c.getConvertTo() + "&compact=ultra&apiKey=" + apiKey, String.class);

		int amount = Integer.parseInt(c.getAmount());
		JSONObject obj = new JSONObject(jsonString);
		double currencyRate = obj.getDouble(c.getFrom() + "_" + c.getConvertTo());
		double output = currencyRate * amount;
		modelMap.addAttribute("output", output);
		historyService
				.addHistory(new History(null, c.getFrom(), c.getConvertTo(), c.getAmount(), output, LocalDate.now()));

		hs.setAttribute("historyData", historyService.fetchAllHistory());
		return "/main";
	}

}
