package in.tech_camp.javascript_skillcheck_java.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.tech_camp.javascript_skillcheck_java.entity.ArticleEntity;
import in.tech_camp.javascript_skillcheck_java.form.ArticleForm;
import in.tech_camp.javascript_skillcheck_java.repository.ArticleRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ArticleController {
    private final ArticleRepository articleRepository;

  @GetMapping("/")
  public String showList(Model model) {
    var articleList = articleRepository.findAll();
    model.addAttribute("articleList", articleList);
    model.addAttribute("articleForm", new ArticleForm());
    return "articles/index";
  }

  @PostMapping("/articles")
  public ResponseEntity<ArticleEntity> saveArticle(@ModelAttribute("articleForm") ArticleForm form){
    ArticleEntity article = new ArticleEntity();
    article.setText(form.getText());
    articleRepository.insert(article);
    ArticleEntity resultArticle = articleRepository.findById(article.getId());
    return ResponseEntity.ok(resultArticle);
  }
}
