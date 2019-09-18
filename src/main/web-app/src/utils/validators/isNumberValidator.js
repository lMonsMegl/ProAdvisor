import validate from 'validate.js';

export function isNumberValidator(string) {
  return {
    valid: !validate({ string }, {
      string: {
        numericality: true
      }
    }),
    message: 'Must be a number'
  };
}
