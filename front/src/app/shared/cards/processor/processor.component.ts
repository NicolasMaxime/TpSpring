import {Component, Input, OnInit} from '@angular/core';
import {Processor} from '../../interfaces/processor';

@Component({
  selector: 'app-processor',
  templateUrl: './processor.component.html',
  styleUrls: ['./processor.component.css']
})
export class ProcessorComponent implements OnInit {
  private _processor: Processor;

  constructor() {
    this._processor = {} as Processor;
  }

  ngOnInit(): void {
  }

  @Input('processor')
  set processor(value: Processor) {
    this._processor = value;
  }

  get processor(): Processor{
    return this._processor;
  }
}
