import { TestBed } from '@angular/core/testing';

import { ProtectionMeasureService } from './protection-measure.service';

describe('ProtectionMeasureService', () => {
  let service: ProtectionMeasureService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProtectionMeasureService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
