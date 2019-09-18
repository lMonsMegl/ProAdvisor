import React from 'react';
import PropTypes from 'prop-types';

const Button = ({ title, onClick, className }) => {
  return (
      <button type="button" onClick={onClick} className={className}>
        {title}
      </button>
  );
};

Button.propTypes = {
  title: PropTypes.string,
  onClick: PropTypes.func.isRequired,
  className: PropTypes.string
};

Button.defaultProps = {
  className: '',
  title: ''
};

export default Button;
