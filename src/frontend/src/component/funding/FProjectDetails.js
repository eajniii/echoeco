import React from 'react';
import { useParams } from 'react-router-dom';

const FundingDetails = () => {
  const fundingProjectId = useParams().fundingProjectId;
  const FundingDetails = () => {
    const { fundingProjectId } = useParams();
    return (
      <>
        <h3>Project No. {fundingProjectId}</h3>
      </>
    );
  };
};
export default FundingDetails;
