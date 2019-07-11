import {Routes} from '@angular/router';
import {InscriptionComponent} from './inscription/inscription.component';
import {PageAcceuilComponent} from './page-acceuil/page-acceuil.component';
import {InscriptionPatientComponent} from './inscription-patient/inscription-patient.component';
import {LoginComponent} from './login/login.component';
import {InscriptionPraticienComponent} from './inscription-praticien/inscription-praticien.component';




export const routes: Routes = [
  {path: 'inscription', component: InscriptionComponent},
  {path: 'accueil', component : PageAcceuilComponent},
  {path: 'login', component: LoginComponent},
  {path: 'inscriptionPraticien', component: InscriptionPraticienComponent},
  {path: 'inscriptionPatient', component: InscriptionPatientComponent},
  {path: 'login', component: LoginComponent}
];

