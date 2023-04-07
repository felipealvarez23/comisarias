import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {StartRequestComponent} from './start-request/start-request.component';
import {ProtectionMeasureRoutingModule} from "./protection-measure-routing.module";
import {ReactiveFormsModule} from "@angular/forms";
import { PersonalInformationComponent } from './personal-information/personal-information.component';
import {SharedModule} from "../../shared/shared.module";

@NgModule({
  declarations: [
    StartRequestComponent,
    PersonalInformationComponent
  ],
    imports: [
        CommonModule,
        ProtectionMeasureRoutingModule,
        ReactiveFormsModule,
        SharedModule
    ]
})
export class ProtectionMeasureModule { }
