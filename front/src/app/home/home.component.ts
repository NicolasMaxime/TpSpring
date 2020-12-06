import { Component, OnInit } from '@angular/core';
import {Processor} from "../shared/interfaces/processor";
import {ProcessorService} from "../shared/service/processor.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private _value: number;

  constructor(private readonly _procService: ProcessorService) {
    this._value = undefined;
  }

  ngOnInit(): void {
  }

  get value(): number{
    return  this._value;
  }

  assignvalue($event: number) {
    this._value = $event;
  }
}
