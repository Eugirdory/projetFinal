import {Routes} from '@angular/router';
import {InscriptionComponent} from './inscription/inscription.component';
import {PageAcceuilComponent} from './page-acceuil/page-acceuil.component';


export const routes: Routes = [
  {path: 'inscription', component: InscriptionComponent},
  {path: 'acceuil', component : PageAcceuilComponent},
];
