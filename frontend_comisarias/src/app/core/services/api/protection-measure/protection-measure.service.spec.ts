import { TestBed } from '@angular/core/testing';

import { ProtectionMeasureService } from './protection-measure.service';
import {HttpClientTestingModule} from "@angular/common/http/testing";

describe('ProtectionMeasureService', () => {
  let service: ProtectionMeasureService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule]
    });
    service = TestBed.inject(ProtectionMeasureService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
