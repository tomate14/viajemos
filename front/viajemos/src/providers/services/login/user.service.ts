import { Injectable } from '@angular/core';
import { SocialUser } from 'angular4-social-login';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  user: SocialUser;
  constructor() { }
}
