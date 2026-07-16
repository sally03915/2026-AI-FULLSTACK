//1. React Test Library - dom
import '@testing-library/jest-dom';

//2. react 테스트 끝나면 cleanup 자동실행- dom 정리
import { cleanup } from '@testing-library/react';
afterEach(() => {
  cleanup();
});