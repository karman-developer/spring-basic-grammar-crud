package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Item;
import com.example.demo.form.ItemForm;
import com.example.demo.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	private final ItemService itemService;
	
	@Autowired
	public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

	@GetMapping
	public String index(Model model) {
		List<Item> items = this.itemService.findAll();
		System.out.println(items.toString());
		return "item/index";
	}

	// 登録
	@GetMapping("toroku")
	public String torokuPage(@ModelAttribute ItemForm itemForm) {
		return "item/torokuPage";
	}

	@PostMapping("toroku")
	public String toroku(@ModelAttribute ItemForm itemForm) {
		return "redirect:/item";
	}

	// 編集
	@GetMapping("henshu/{id}")
	public String henshuPage(@PathVariable Integer id, Model model, ItemForm itemForm) {
		return "item/henshuPage";
	}

	@PostMapping("henshu/{id}")
	public String henshu(@PathVariable("id") Integer id, @ModelAttribute("itemForm") ItemForm itemForm) {
		// 処理を追加

		return "redirect:/item";
	}

	// 商品削除の実行
	@PostMapping("sakujo/{id}")
	public String sakujo(@PathVariable("id") Integer id) {

		return "redirect:/item";
	}
}
