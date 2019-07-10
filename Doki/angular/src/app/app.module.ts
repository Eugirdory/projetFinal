import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import {RouterModule} from '@angular/router';
import {routes} from './routes';
import { PatientComponent } from './patient/patient.component';
import {MenuComponent} from './menu/menu.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { PageAcceuilComponent } from './page-acceuil/page-acceuil.component';

@NgModule({
  declarations: [
    AppComponent,
    PatientComponent
    MenuComponent,
    InscriptionComponent,
    PageAcceuilComponent
  ],
  imports: [
    BrowserModule, FormsModule, RouterModule.forRoot(routes), HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
