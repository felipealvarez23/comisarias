import {StartRequestComponent} from "./start-request/start-request.component";
import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {PersonalInformationComponent} from "./personal-information/personal-information.component";

const routes: Routes = [
  {
    path: '',
    component: StartRequestComponent
  },
  {
    path: 'informacion-personal',
    component: PersonalInformationComponent
  }
];
@NgModule({
  imports: [
    RouterModule.forChild(routes),
  ],
  exports: [
    RouterModule
  ]
})
export class ProtectionMeasureRoutingModule {}
