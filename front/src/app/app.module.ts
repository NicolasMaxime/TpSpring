import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProcessorsComponent } from './processors/processors.component';
import { ProcessorComponent } from './shared/cards/processor/processor.component';
import {MatCardModule} from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from "@angular/material/button";
import { SearchBarComponent } from './search-bar/search-bar.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { AddDialogComponent } from './shared/dialog/add-dialog/add-dialog.component';
import { AddFormComponent } from './shared/form/add-form/add-form.component';
import {MatDialogModule} from "@angular/material/dialog";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProcessorsComponent,
    ProcessorComponent,
    SearchBarComponent,
    AddDialogComponent,
    AddFormComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    HttpClientModule,
    MatDialogModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
