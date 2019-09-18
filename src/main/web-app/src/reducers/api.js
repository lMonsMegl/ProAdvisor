import english from '../db/en';
import russian from '../db/ru';
import ukrainian from '../db/ua';

export function languageData(language) {
  switch (language) {
    case 'GB':
      return english;
    case 'UA':
      return ukrainian;
    case 'RU':
      return russian;
    default:
      return english;
  }
}
