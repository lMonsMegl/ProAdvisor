import validate from 'validate.js';

export function stringLengthValidator({ min, max, is } = {}) {
  return string => ({
    valid: !validate({ string }, {
      string: {
        length: {
          is,
          min,
          max
        }
      }
    }),
    message: is && `Must be ${is} chars length` ||
        min && `Must be min ${min} chars length` ||
        max && `Must be max ${max} chars length` ||
        `Must be between ${min} and ${max} chars length`
  });
}
