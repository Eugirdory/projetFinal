import {Routes} from '@angular/router';
import {PatientComponent} from './patient/patient.component';
import {InscriptionComponent} from './inscription/inscription.component';


export const routes: Routes = [
  {path: 'inscription', component: InscriptionComponent},
  {path: 'patient', component: PatientComponent},
];
