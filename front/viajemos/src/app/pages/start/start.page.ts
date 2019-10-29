import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/providers/services/login/user.service';
import { SocialUser } from 'angular4-social-login';

@Component({
  selector: 'app-start',
  templateUrl: './start.page.html',
  styleUrls: ['./start.page.scss'],
})
export class StartPage implements OnInit {

  title:string;
  imagen:String;
  usuario: SocialUser;
  textoInicial:String;
  textoFinal:String;

  constructor(private userService:UserService) {
    this.title = 'Bienvenido a tramita2';
    this.textoInicial = "Hola"
    this.textoFinal = " te damos la bienvenida"
  }
  
  ngOnInit() {
    this.userService.user.name = this.userService.user.name;
    this.usuario = this.userService.user;
    this.imagen = this.userService.user.photoUrl;
  }

}
