import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Processor} from '../../interfaces/processor';

@Component({
  selector: 'app-processor',
  templateUrl: './processor.component.html',
  styleUrls: ['./processor.component.css']
})
export class ProcessorComponent implements OnInit {
  private _processor: Processor;
  private _delete$: EventEmitter<Processor>
  private _update$: EventEmitter<Processor>

  constructor() {
    this._processor = {} as Processor;
    this._delete$ = new EventEmitter<Processor>();
    this._update$ = new EventEmitter<Processor>();
  }

  ngOnInit(): void {
  }

  @Input('processor')
  set processor(value: Processor) {
    if (!value.photo){
      value.photo = '../../../assets/ORDINATEUR.jpg';
    }
    this._processor = value;
  }

  get processor(): Processor{
    return this._processor;
  }

  @Output('delete')
  get delete$(): EventEmitter<Processor>{
    return this._delete$;
  }

  delete() {
    this._delete$.emit(this._processor);
  }

  @Output('update')
  get update$(): EventEmitter<Processor>{
    return this._update$;
  }

  update() {
    this._update$.emit(this._processor);
  }
}
