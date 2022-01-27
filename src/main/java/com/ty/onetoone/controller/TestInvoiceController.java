package com.ty.onetoone.controller;

import com.ty.onetoone.dao.ItemInvoiceDao;
import com.ty.onetoone.dto.Invoice;
import com.ty.onetoone.dto.Item;

public class TestInvoiceController {

	public static void main(String[] args) {
		
		ItemInvoiceDao dao =  new ItemInvoiceDao();
		
		Item item = new Item();
		item.setId(2);
		item.setName("Printer");
		item.setPrice(15000);
		item.setQuantity(2);
		
		Invoice invoice = new Invoice();
		invoice.setId(2);
		invoice.setName("Printer invoice");
		invoice.setBillingAddress("BLR BSD");
		invoice.setGstNumber("2154ptr");
		invoice.setTax(18.32);
		invoice.setItem(item);
		
		dao.saveInvoice(invoice, item);
		
	}

}
