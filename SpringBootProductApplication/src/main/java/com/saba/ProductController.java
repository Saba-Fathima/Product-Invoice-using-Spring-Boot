package com.saba;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {


	@RequestMapping("/")
	public String productPage()
	{
		return "product";
	}

	@RequestMapping("/req1")
	public String invoicePage(@RequestParam int cid,@RequestParam String cname,@RequestParam long mobile,@RequestParam String pname,@RequestParam double price,@RequestParam int qty,ModelMap model)
	{
		model.put("cid", cid);
		model.put("cname", cname);
		model.put("mobile", mobile);
		model.put("pname", pname);
		model.put("price", price);
		model.put("qty", qty);

		double total = price * qty;
				model.put("total", total);

		double discount = 0;
		if(total < 25000)
		{
			discount = total * 10 / 100;
		}
		else if(total >= 25000 && total < 50000)
		{
			discount = total * 15 / 100;
		}
		else
		{
			discount = total * 30 / 100;
		}
		double gst = total * 18 / 100;
		double invoiceBill = total - discount + gst;

		model.put("discount", discount);
		model.put("gst", gst);
		model.put("invoiceBill", invoiceBill);

		return "result";
	}
}
