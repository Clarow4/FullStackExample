import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
  
  /*
   *used to make sure data coming in from backend is correct
  */
  export class ArticlesService {
  
    private url = 'http://localhost:8080/articles/';
  
    constructor(private http: HttpClient) {
    }
  
    getArticles(): Observable<any> {
      return this.http.get(`${this.url}`);
    }
  }