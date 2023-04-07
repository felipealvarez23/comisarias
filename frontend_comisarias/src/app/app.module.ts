import {ErrorHandler, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SkeletonComponent} from './layout/skeleton/skeleton.component';
import {HeaderComponent} from './layout/header/header.component';
import {FooterComponent} from './layout/footer/footer.component';
import {HttpClientModule} from "@angular/common/http";
import {GlobalErrorHandler} from "./core/errors/global-error-handler";
import {SharedModule} from "./shared/shared.module";

@NgModule({
  declarations: [
    AppComponent,
    SkeletonComponent,
    HeaderComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    SharedModule
  ],
  providers: [
    {
      provide: ErrorHandler,
      useClass: GlobalErrorHandler
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
