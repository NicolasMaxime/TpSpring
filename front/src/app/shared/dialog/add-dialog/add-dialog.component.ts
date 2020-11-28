import {Component, Inject, OnInit, Optional} from '@angular/core';
import {Processor} from "../../interfaces/processor";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-add-dialog',
  templateUrl: './add-dialog.component.html',
  styleUrls: ['./add-dialog.component.css']
})
export class AddDialogComponent implements OnInit {

  constructor(private _dialogRef: MatDialogRef<AddDialogComponent>, @Optional() @Inject(MAT_DIALOG_DATA) private _processor: Processor) {
  }

  /**
   * Returns person passed in dialog open
   */
  get processor(): Processor {
    return this._processor;
  }

  /**
   * OnInit implementation
   */
  ngOnInit(): void {
  }

  /**
   * Function to cancel the process and close the modal
   */
  onCancel(): void {
    this._dialogRef.close();
  }

  /**
   * Function to close the modal and send person to parent
   */
  onSave(processor: Processor): void {
    this._dialogRef.close(processor);
  }

}
