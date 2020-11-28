import {Component, EventEmitter, Input, OnChanges, OnInit, Output} from '@angular/core';
import {Processor} from "../../interfaces/processor";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-add-form',
  templateUrl: './add-form.component.html',
  styleUrls: ['./add-form.component.css']
})
export class AddFormComponent implements OnInit, OnChanges {

  private _cancel$: EventEmitter<void>;
  private _submit$: EventEmitter<Processor>;
  private _model: Processor;
  private _isUpdatedModel: boolean;
  private _form: FormGroup;

  /**
   * Constructor for FormSignInComponent
   */
  constructor() {
    this._cancel$ = new EventEmitter<void>();
    this._submit$ = new EventEmitter<Processor>();
    this._form = this._buildForm();
  }

  @Input('model')
  set model(value: Processor){
    this._model = value;
  }

  get model(): Processor{
    return this._model;
  }

  ngOnInit(): void {
  }

  ngOnChanges(record): void {
    if (record.model && record.model.currentValue) {
      this._model = record.model.currentValue;
      this._isUpdatedModel = true;
    } else {
      this._model = {
        id: 0,
        photo: '',
        nom: '',
        core: 0,
        thread: 0,
      };
      this._isUpdatedModel = false;
    }
    this._form.patchValue(this._model);
  }
  /**
   * Allow event (cancel)
   */
  @Output('cancel')
  get cancel$(): EventEmitter<void> {
    return this._cancel$;
  }

  /**
   * Emit void event when cancel is pushed
   */
  onCancel(): void {
    this._cancel$.emit();
  }

  /**
   * Return the form
   */
  get form(): FormGroup {
    return this._form;
  }


  /**
   * Validation of the form
   * @private
   */
  private _buildForm(): FormGroup {
    return new FormGroup({
      nom: new FormControl('', Validators.required),
      core: new FormControl('', Validators.required),
      thread: new FormControl('', Validators.required)
    });
  }

  /**
   * Allow event (save)
   */
  @Output('save')
  get submit$(): EventEmitter<Processor>{
    return this._submit$;
  }

  /**
   * Remove verification and keep only the password
   * @param user
   */
  onSubmit(processor: Processor): void{
    if (this._model != null)
      processor.id = this._model.id;
    this._submit$.emit(processor);
  }
}
