import {Component, OnInit} from '@angular/core';
import {Articles} from './articles/Articles';
import {ArticlesService} from './articles/articles-service.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  title = 'Articles';
  articles: Articles[] = [];
  date = new Date();
  day = this.date.toLocaleDateString('default', { weekday: 'short' });
  month = this.date.toLocaleString('default', { month: 'short' })
  today = new Date().getDate();
  year = new Date().getFullYear();
  
  constructor(private router: Router, private articleService: ArticlesService) {
  }
  
  getArticles() {
    this.articleService.getArticles().subscribe(data => {
      this.articles = data;
    });
  }

  ngOnInit(): void {
    this.router.events.subscribe(value => {
      this.getArticles();
    });
  }
}