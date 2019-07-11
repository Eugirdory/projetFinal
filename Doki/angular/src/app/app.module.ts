import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {AppComponent} from './app.component';
import {RouterModule} from '@angular/router';
import {routes} from './routes';
import {PatientComponent} from './patient/patient.component';
import {MenuComponent} from './menu/menu.component';
import {InscriptionComponent} from './inscription/inscription.component';
import {PageAcceuilComponent} from './page-acceuil/page-acceuil.component';
import {LoginComponent} from './login/login.component';
import {BarreRechercheComponent} from './barre-recherche/barre-recherche.component';
import {AuthenticationService} from './services/authentication.service';
import {PraticienService} from './services/praticien-service';
import { PraticienComponent } from './praticien/praticien.component';
import { PraticienDetailComponent } from './praticien-detail/praticien-detail.component';
import {InscriptionPraticienComponent} from './inscription-praticien/inscription-praticien.component';
import { InscriptionPatientComponent } from './inscription-patient/inscription-patient.component';


@NgModule({
  declarations: [
    AppComponent,
    PatientComponent,
    MenuComponent,
    InscriptionComponent,
    PageAcceuilComponent,
    LoginComponent,
    BarreRechercheComponent,
    PraticienComponent,
    PraticienDetailComponent,
    InscriptionPraticienComponent,
    InscriptionPatientComponent,

  ],
  imports: [
    BrowserModule, FormsModule, RouterModule.forRoot(routes), HttpClientModule
  ],
  providers: [AuthenticationService, PraticienService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
