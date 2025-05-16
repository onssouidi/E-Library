package com.store.controller;

import com.store.models.BookModel;
import com.store.models.CartItem;
import com.store.repository.BookRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/add")
    public String addToCart(@RequestParam Integer bookId, @RequestParam(defaultValue = "1") int quantity, HttpSession session, RedirectAttributes redirectAttributes) {
        BookModel book = bookRepository.findById(bookId).orElse(null);
        if (book == null) return "redirect:/books";

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) cart = new ArrayList<>();

        boolean exists = false;
        for (CartItem item : cart) {
            if (item.getBook().getId().equals(bookId)) {
                item.setQuantity(item.getQuantity() + quantity);
                exists = true;
                break;
            }
        }

        if (!exists) cart.add(new CartItem(book, quantity));
        session.setAttribute("cart", cart);

        System.out.println("Item added to cart!");
        return "redirect:/books";
    }

    @GetMapping
    public String viewCart(HttpSession session, Model model) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        double total = cart.stream().mapToDouble(CartItem::getTotalPrice).sum();

        model.addAttribute("cart", cart);
        model.addAttribute("total", total);

        return "cart";  // Ensure this matches your Thymeleaf template name
    }

    @GetMapping("/clear")
    public String clearCart(HttpSession session) {
        session.removeAttribute("cart");
        return "redirect:/cart";
    }

    @PostMapping("/checkout")
    public String checkout(HttpSession session, Model model) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            model.addAttribute("message", "Votre panier est vide.");
            return "order";
        }

        double total = cart.stream().mapToDouble(CartItem::getTotalPrice).sum();
        session.removeAttribute("cart");

        model.addAttribute("message", "Commande validée avec succès !");
        model.addAttribute("total", total);

        return "order";
    }
}
