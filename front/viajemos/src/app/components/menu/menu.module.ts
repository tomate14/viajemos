import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouteReuseStrategy, RouterModule } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';

import { MenuComponent } from './menu.component';

import { MenuRoutingModule } from './menu-routing.module';
import { CommonModule } from '@angular/common';


@NgModule({
  
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild([
      {
        path: '',
        component: MenuComponent
      }
    ])
  ],
  declarations: [MenuComponent]
})
export class MenuModule {}

